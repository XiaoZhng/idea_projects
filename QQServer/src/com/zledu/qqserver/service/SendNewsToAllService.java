package com.zledu.qqserver.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;
import com.zledu.utility.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Alonso
 * 该类/对象 是服务端推送消息给客户端
 */
public class SendNewsToAllService implements Runnable{

    @Override
    public void run() {

        while (true) {
            //服务器推送消息
            //把要推送的消息存入Message对象中
            System.out.print("请输入要推送的消息(输入exit退出):");
            String content = Utility.readString(100);
            //退出判断
            if ("exit".equals(content)){
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(content);
            message.setMesType(MessageType.MESSAGE_To_All);
            message.setSendTime(new Date().toString());

            //取出服务端集合中的所有线程
            HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
            //遍历集合中的线程
            Set<String> keySet = hm.keySet();
            for (String userId : keySet) {
                try {
                    //创建对象输出流，把Message对象发送给每个客户端线程
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hm.get(userId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
