package com.zledu.qqserver.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;
import com.zledu.qqcommon.User;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alonso
 * 该类是服务端连接客户端的线程
 */
public class ServerConnectClientThread implements Runnable {
    //持有一个Socket
    private Socket socket;
    private String userid;//连接到服务端的用户id
    private boolean loop = true;

    public ServerConnectClientThread(Socket socket, String userid) {
        this.socket = socket;
        this.userid = userid;
    }

    //获取对应的Socket
    public Socket getSocket() {
        return socket;
    }

    //线程处于运行状态，可以发送或接收消息
    @Override
    public void run() {
        while (loop) {
            try {
                System.out.println("服务端和客户端" + userid + "保持通信，读取数据...");
                //读数据
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //接收从客户端发送来的Message对象
                Message message = (Message) ois.readObject();
                //根据客户端传过来的Message，做相应处理

                //先得到管理线程的集合
                HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();

                //客户端发送的类型是 MESSAGE_GET_ONLINE_FRIEND，从服务端接收的类型是 MESSAGE_RET_ONLINE_FRIEND
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    //规定 在线用户列表形式：100 200 jack
                    System.out.println(message.getSender() + " 要在线用户列表");
                    //获取在线用户列表
                    String onlineUser = ManageServerConnectClientThread.getOnlineUser();
                    //构建一个Message，返回给客户端
                    Message message2 = new Message();
                    //返回类型
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    //返回在线用户列表
                    message2.setContent(onlineUser);
                    //返回接收者(就是客户端发送message的发送者)
                    message2.setGetter(message.getSender());
                    //创建对象输出流，返回客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {

                    //私聊消息
                    //获取Message对象中接收者的线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter());

                    //通过迭代器遍历获取线程id，并和message的接收者比较
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next =  iterator.next();
                        //接收者的线程 不等于 管理线程集合中的在线线程(不在线)
                        if (!(next.equals(message.getGetter()))){
                            String getter = message.getGetter();//接收者
                            HashMap<String, Message> ofLine = ManageServerConnectClientThread.getOfLine();
                            ofLine.put(getter, message);//放入离线集合

                            //离线的情况下，返回给发送者信息
                            Message offLine_message = new Message();
                            offLine_message.setGetter(message.getGetter());//接收者
                            offLine_message.setSender(message.getSender());//发送者
                            offLine_message.setMesType(MessageType.Message_offLine);//消息类型
                            ObjectOutputStream oos1 =
                                    new ObjectOutputStream(hm.get(message.getSender()).getSocket().getOutputStream());
                            oos1.writeObject(offLine_message);
                        }else { //接收者的线程 等于 管理线程集合中的在线线程(在线)
                            //得到对应socket的对象输出流，将message对象转发给指定的客户端
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                            oos.writeObject(message);//转发，提示如果用户不在线，可以保存到数据库，这样就可以实现离线留言
                        }
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_To_All)) {
                    //群发消息
                    //遍历线程集合，获取集合中每个线程的socket
                    hm = ManageServerConnectClientThread.getHm();
                    Set<String> keySets = hm.keySet();
                    //取出在线用户id
                    for (String key : keySets) {

                        //排除群发消息给发送者
                        if (!key.equals(message.getSender())) {

                            //转发message
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(key).getSocket().getOutputStream());
                            oos.writeObject(message);

                        }
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //发送文件
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (!(next.equals(message.getGetter()))){
                            String getter = message.getGetter();//接收者
                            HashMap<String, Message> ofLine = ManageServerConnectClientThread.getOfLine();
                            ofLine.put(getter, message);//放入离线集合

                            //离线的情况下，返回给发送者信息
                            Message offLine_message = new Message();
                            offLine_message.setGetter(message.getGetter());//接收者
                            offLine_message.setSender(message.getSender());//发送者
                            offLine_message.setMesType(MessageType.Message_offLine);//消息类型
                            ObjectOutputStream oos1 =
                                    new ObjectOutputStream(hm.get(message.getSender()).getSocket().getOutputStream());
                            oos1.writeObject(offLine_message);
                        }else {

                            //根据客户端发送的Message对象，获取对应的线程，将Message转发
                            //转发
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    //退出指定线程
                    //从客户端发送的退出Message对象中，取到id，并把对应线程从集合中移除即可
                    System.out.println(message.getSender() + " 退出");
                    ManageServerConnectClientThread.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    break;

                } else {
                    System.out.println("其他类型，暂时不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
