package homework;

import upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alonso
 * 服务端
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        //1.监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        System.out.println("服务端在等待接收文件..");
        Socket socket = serverSocket.accept();
        //3.接收客户端 发送要下载的文件夹名
        InputStream inputStream = socket.getInputStream();
        //创建一个字节数组
        byte[] b = new byte[1024];
        int len = 0;
        String downLoadFile = "";
        //这里使用 while循环读取文件名，是考虑将来客户端的数据较大的情况
        while ((len = inputStream.read(b)) != -1){
            //System.out.println(new String(b, 0, len));
            downLoadFile += new String(b, 0, len);
        }
        System.out.println("客户端要下载的文件夹名=" + downLoadFile);

        //4.判断接收到的文件夹名
        //如果 接收到的文件夹名是素材视频，则返回该文件，否则一律返回 qie.png
        String resFileName = "";
        if ("素材视频".equals(downLoadFile)){
            resFileName = "src\\素材视频.mp4";
        }else {
            resFileName = "src\\qie.png";
        }

        //5.创建一个输入流文件，读取该文件
        //BufferedInputStream 和 BufferedOutputStream都是 字节流!!!
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));

        //6.使用工具类StreamUtils，读取该文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //7.将字节数组写入到数据通道，返回给客户端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();//设置结束标记

        //8.关闭相关的资源
        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭..");
    }
}
