package com.zledu.qqclient.service;

import com.zledu.qqcommon.Message;
import com.zledu.qqcommon.MessageType;

import java.io.*;

/**
 * @author Alonso
 * 该类/对象 完成文件传输服务
 */
public class FileClientService {

    //编写方法，完成文件传输
    /**
     *
     * @param src 源文件路径
     * @param dest 接收者存放的路径
     * @param sender 发送者
     * @param getter 接收者
     */
    public static void sendFile(String src, String dest, String sender, String getter){

        //把文件信息封装到Message对象
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSrc(src);
        message.setDest(dest);
        message.setSender(sender);
        message.setGetter(getter);

        //将源文件读取
        FileInputStream fileInputStream = null;
        byte[] bytes = new byte[(int) new File(src).length()];//字节数组缓存
        //byte[] bytes = new byte[1024];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(bytes);//将src文件读入到字节数组中
            //把字节数组放到message中
            message.setBytes(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭对应流
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n" + sender + " 给 " + getter + " 发送文件： " + src
                + " 到对方电脑的目录： " + dest);

        //发送到服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
