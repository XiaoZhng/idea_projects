package com.zledu.qqclient.view;

import com.zledu.qqclient.service.ClientConnectServerThread;
import com.zledu.qqclient.service.FileClientService;
import com.zledu.qqclient.service.MessageClientService;
import com.zledu.qqclient.service.UserClientService;
import com.zledu.qqclient.utility.Utility;


/**
 * @author Alonso
 * 客户端的菜单界面
 */
public class QQView {
    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入
    private UserClientService userClientService = new UserClientService();//对象是用于登录服务端和注册用户
    private MessageClientService messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();
    //显示主菜单
    public void mainMenu(){
        while (loop){
            System.out.println("============欢迎登录网络通信系统============");
            System.out.println("\t\t 1.登录系统");
            System.out.println("\t\t 9.退出系统");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);//控制输入的长度

            //根据用户的输入来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户名：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码：");
                    String passwd = Utility.readString(50);
                    //这里编写一个类 UserClientService[用户登录/用户注册]
                    if (userClientService.checkUser(userId, passwd)) {//用户名密码正确，进入二级菜单
                        System.out.println("============欢迎(" + userId + ")用户登录成功============");
                        while (loop) {
                            System.out.println("============网络通信系统二级菜单(用户" + userId + ")============");
                            System.out.println("\t\t1.显示在线用户列表");
                            System.out.println("\t\t2.群发消息");
                            System.out.println("\t\t3.私聊消息");
                            System.out.println("\t\t4.发送文件");
                            System.out.println("\t\t9.退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //这里写个方法，来获取在线用户列表
                                    userClientService.onlineFriendList();
                                    //System.out.println("1.显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的消息:");
                                    String   s = Utility.readString(100);
                                    //编写方法，将消息封装成Message对象，发送给服务端
                                    messageClientService.sendMessageToAll(userId, s);
                                    //System.out.println("2.群发消息");
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户名(在线):");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入聊天消息:");
                                    String content = Utility.readString(100);
                                    //编写方法，将聊天消息发送给服务端
                                    messageClientService.sendMessage(userId, getterId, content);
                                    //System.out.println("3.私聊消息");
                                    break;
                                case "4":
                                    System.out.print("请输入对方的id:");
                                    String getter = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径(d:\\xx.jpg):");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入对方保存文件的路径(d:\\xx.jpg):");
                                    String dest = Utility.readString(100);
                                    //编写方法，发送文件
                                    FileClientService.sendFile(src, dest, userId, getter);
                                    //System.out.println("4.发送文件");
                                    break;
                                case "9":
                                    //编写方法，让主线程退出后，对应的子线程也退出
                                    userClientService.exitThread();
                                    loop = false;
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("密码错误...");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
        System.out.println("客户端退出系统...");
    }

}
