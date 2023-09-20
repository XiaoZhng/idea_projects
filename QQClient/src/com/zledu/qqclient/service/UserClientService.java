package com.zledu.qqclient.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;
import com.zledu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Alonso
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {

    //因为我们可能在其他地方使用user信息
    private User u = new User();
    private Socket socket;

    //根据userId、pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接服务端，发送u
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //通过对象输出流发送给服务端
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            //接收服务端传回的message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //因为读取的是object类型，所以要转成message
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {
                //登录成功

                //创建一个和服务端保持通信的线程类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //clientConnectServerThread.start();//启动客户端的线程
                new Thread(clientConnectServerThread).start();
                //这里为了后面客户端的扩展，我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);

                b = true;
            } else {
                //登录失败，就不能启动和服务端通信的线程，关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //向服务端请求在线用户列表
    public void onlineFriendList(){

        //发送一个message，类型 MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务端
        try {
            //从管理线程的集合中，通过userId，得到这个线程
            ClientConnectServerThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
                //得到当前线程的Socket 对应的 ObjectOutputStream对象
            OutputStream outputStream = clientConnectServerThread.getSocket().getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(message);//发送一个Message对象，向服务端要求在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务端发送退出请求
    public void exitThread(){
        //给服务端发送一个Message对象
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//这里一定要指定是哪个客户端id，这样服务端才能关闭对应id的线程

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    @Test
//    public void f1(){
//        int a = 10;
//        //a++=10，然后a+1得11，之后a--=11，10+11=21
//        System.out.println(a++ + a--);
//    }
}
