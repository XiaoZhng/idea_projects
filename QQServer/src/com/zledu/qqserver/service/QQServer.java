package com.zledu.qqserver.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;
import com.zledu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alonso
 * 服务端，监听9999端口，等待客户端连接，并保持通信
 */
public class QQServer {

    private ServerSocket serverSocket = null;
    private Socket socket;
    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法
    //private static HashMap<String, User> validUsers = new HashMap<>();
    //这里我们也可以使用 ConcurrentHashMap，可以处理并发的集合，没有线程安全
    //HashMap 没有线程安全，因此在多线程情况下是不安全
    //ConcurrentHashMap 处理的线程安全，即线程同步处理，在多线程情况下是安全
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Message> messagehm = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, Message> getMessagehm() {
        return messagehm;
    }

    public Socket getSocket() {
        return socket;
    }

    //在静态代码块中，初始化 validUsers集合
    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("jack", new User("jack", "123456"));
        validUsers.put("张三", new User("张三", "123456"));
    }

    //编写方法，判断用户是否合法
    public boolean checkUser(String userId, String passwd) {
        User user = validUsers.get(userId);

        //如果 validUsers集合中没有找到，则返回false
        if (user == null) {
            return false;
        }
        //如果密码和集合中的密码不一样，则返回false
        if (!user.getPasswd().equals(passwd)) {
            return false;
        }

        //过关斩将，用户名和密码正确，返回true
        return true;
    }


    //1、接收到服务端发送的Message后，先判断 接收者(getter)是否在线，编写方法
    //编写方法，判断接收者是否在线
    public static void LiXian(String getter, Message message) {

        /*
           1、接收到服务端发送的Message后，先判断 接收者(getter)是否在线，编写方法
           2、如果 getter不在线，就把Message对象存入一个集合中
           3、实时监听集合中的线程，如果上线了，就发送
        */

        //判断接收者是否在线(集合中是否有该key值)
        //containsKey()：检查 hashMap 中是否存在指定的 key 对应的映射关系。
        if (!ManageServerConnectClientThread.getHm().containsKey(getter)){
            //如果不在的话，就把Message对象的接收者和内容存入集合中
            messagehm.put(getter, message);
        }
        if (ManageServerConnectClientThread.getHm().containsKey(getter)){
            //在线的情况下，拿到value值(Message)
            Message message1 = messagehm.get(getter);

        }
    }

    //在构造器中监听9999端口，等待客户端连接，并保持通信
    public QQServer() {

        try {
            System.out.println("服务端在9999端口监听...");
            new Thread(new SendNewsToAllService()).start();//启动服务端推送消息线程
            //new Thread(new OffLineThread()).start();//启动管理离线消息的线程
            //监听9999端口
            serverSocket = new ServerSocket(9999);
            //服务端要持续监听，所以循环
            while (true) {
                Socket socket = serverSocket.accept();//如果没有客户端连接，就会阻塞在这里
                //创建对象输入流，接收客户端传入的User对象
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //从客户端接收到的User对象，用于用户认证
                User user = (User) ois.readObject();
                //从客户端接收到的Message对象
                //Message messages = (Message) ois.readObject();

                //调用判断是否在线方法
                //LiXian(messages.getGetter(), messages);

                //创建一个message对象和一个对象输出流，让登陆成功得以返回
                Message message = new Message();
                //按照题目要求，用户名=100， 密码=123456，则登陆成功
                if (checkUser(user.getUserId(), user.getPasswd())) {
                    //登录成功
                    //则应该返回一个message对象给客户端
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCESS);
                    oos.writeObject(message);
                    //创建和客户端保持通信的线程类 ServerConnectClientThread
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, user.getUserId());
                    //启动线程
                    new Thread(serverConnectClientThread).start();
                    //把该线程对象放入集合中，进行管理 ManageServerConnectClientThread
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), serverConnectClientThread);

                    //遍历离线集合的id 是否和 客户端接收到的User对象相等
                    HashMap<String, Message> ofLine = ManageServerConnectClientThread.getOfLine();
                    Iterator<String> iterator = ofLine.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        //客户端传过来登录成功的用户id 等于 离线线程集合中的id，就说明有离线信息
                        if (next.equals(user.getUserId())){
                            //拿到离线集合中的离线信息message
                            Message offLine_message = ofLine.get(next);
                            oos = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(user.getUserId()).getSocket().getOutputStream());
                            oos.writeObject(offLine_message);
                            ManageServerConnectClientThread.removeofLine(user.getUserId());
                        }
                    }
                } else {
                    //登录失败
                    System.out.println("用户名=" + user.getUserId() + " 密码=" + user.getPasswd() + "，验证失败...");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FALT);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务端退出了while，说明服务端不再监听，因此关闭ServerSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
