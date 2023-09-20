package com.zledu.qqclient.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author Alonso
 * 该类是客户端连接服务端的线程
 */
public class ClientConnectServerThread implements Runnable { //这里可以继承Thread类，也可以实现Runnable接口
    //该线程持有Socket
    private Socket socket;

    //构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    //因为线程需要在后台和服务端通信，因此做成while循环
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端线程，等待从读取服务端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务端没有发送message对象，线程会阻塞在这里
                Message ms = (Message) ois.readObject();
                //判断接收到的Message类型，然后做相应的业务处理
                //如果读取到的是 服务端返回的在线用户列表
                //客户端发送的类型是 MESSAGE_GET_ONLINE_FRIEND，从服务端接收的类型是 MESSAGE_RET_ONLINE_FRIEND
                if (ms.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息，并显示
                    //Content=消息内容
                    //规定
                    String[] onlineUsers = ms.getContent().split(" ");
                    System.out.println("\n=====当前在线用户列表=====");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }

                } else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //把服务端转发的message，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 给 " + ms.getGetter() + " 发送 " + ms.getContent());

                }else if(ms.getMesType().equals(MessageType.Message_offLine)){
                    System.out.println("\n" + ms.getGetter() + "不在线...");
                }
                else if (ms.getMesType().equals(MessageType.MESSAGE_To_All)) {
                    //把服务端转发的message，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 给大家发送 " + ms.getContent());

                }else if (ms.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    //发送文件
                    System.out.println("\n" + ms.getSender() + " 给 " + ms.getGetter()
                            + " 发文件： " + ms.getSrc() + " 到电脑目录： " + ms.getDest());

                    //取出message文件的字节数组，通过输出流写到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(ms.getDest());
                    fileOutputStream.write(ms.getBytes());
                    fileOutputStream.close();
                    System.out.println("\n保存文件成功");
                }
                else {
                    System.out.println("是其他类型，暂时不处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //为了更方便得到Socket
    public Socket getSocket() {
        return socket;
    }
}
