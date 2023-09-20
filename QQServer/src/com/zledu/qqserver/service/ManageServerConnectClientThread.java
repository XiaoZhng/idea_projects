package com.zledu.qqserver.service;

import com.zledu.qqcommon.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alonso
 * 该类用于管理和客户端连接通信的线程
 */
public class ManageServerConnectClientThread {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();
    private static HashMap<String, Message> ofLine = new HashMap<>();

    //将线程添加到集合中
    public static void addServerConnectClientThread(String userid, ServerConnectClientThread serverConnectClientThread){
        hm.put(userid, serverConnectClientThread);
    }

    //通过userid，得到对应的线程
    public static ServerConnectClientThread getServerConnectClientThread(String userid){
       return hm.get(userid);
    }

    //从集合中移除线程
    public static void removeServerConnectClientThread(String userid){
        hm.remove(userid);
    }

    //获取集合
    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
    //获取离线集合
    public static HashMap<String, Message> getOfLine() {
        return ofLine;
    }

    //移除离线用户集合
    public static void removeofLine(String userid){
        ofLine.remove(userid);
    }

    //编写方法，可以返回在线用户列表
    public static String getOnlineUser(){
        //遍历集合
        Set<String> keys = hm.keySet();
        Iterator<String> iterator = keys.iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            //加空格，因为客户端接收是按空格来分割
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }
}
