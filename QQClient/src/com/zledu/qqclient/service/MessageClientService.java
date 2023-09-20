package com.zledu.qqclient.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author Alonso
 * 该类/对象，提供和消息相关的服务方法
 */
public class MessageClientService {

    //编写方法，群发消息
    /**
     *
     * @param sender 发送者
     * @param content 消息内容
     */
    public void sendMessageToAll(String sender, String content){
        //构建Message对象
        Message message = new Message();
        //将 发送者、消息内容 放入message中
        message.setSender(sender);
        message.setContent(content);
        //消息发送的时间
        message.setSendTime(new Date().toString());
        //发送消息类型
        message.setMesType(MessageType.MESSAGE_To_All);//普通聊天消息类型
        System.out.println(sender + " 给 " + "大家" + " 发送 " + content);

        //发送给服务端
        try {
            //从集合中获取发送者的线程，再获取Socket对应的 getOutputStream
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法，用于发送消息
    /**
     *
     * @param sender 发送者
     * @param getter 接收者
     * @param content 消息内容
     */
    public void sendMessage(String sender, String getter, String content){
        //构建Message对象
        Message message = new Message();
        //将 发送者、接收者、消息内容 放入message中
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        //消息发送的时间
        message.setSendTime(new Date().toString());
        //发送消息类型
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通聊天消息类型
        System.out.println(sender + " 给 " + getter + " 发送 " + content);

        //发送给服务端
        try {
            //从集合中获取发送者的线程，再获取Socket对应的 getOutputStream
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
