package com.zledu.qqserver.service;

import com.zledu.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

/**
 * @author Alonso
 */
public class OffLineThread implements Runnable{

    @Override
    public void run() {

        while (true){

            //获取到管理线程的集合
            //HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
            //遍历集合
//            Set<String> keySet = hm.keySet();
//            for (String key : keySet){
//                ConcurrentHashMap<String, Message> OffLinehm = QQServer.getMessagehm();//离线集合
//                KeySetView<String, Message> OffLineKey = OffLinehm.keySet();
//                for (String Offkey : OffLineKey){
//                    //如果服务端集合中的线程Id与存储离线消息集合中的Id相同，则表明上线Id上线成功，发送Message
//                    if (key.equals(Offkey)){
//                        Message OffMessage = OffLinehm.get(Offkey);//拿到离线集合对应的Message
//                        try {
//                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(key).getSocket().getOutputStream());
//                            oos.writeObject(OffMessage);
//                            OffLinehm.remove(Offkey);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
            //System.out.println("服务端遍历集合中的线程个数= " + hm.size());
        }
    }
}
