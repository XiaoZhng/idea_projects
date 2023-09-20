package homework;

import upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Alonso
 * 客户端
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        //1.连接服务端(ip,端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2.创建一个输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，将数据写入到数据通道
        String n = "素材视频";
        outputStream.write(n.getBytes());
        //设置写入结束标记
        socket.shutdownOutput();

        //4.接收服务端返回的文件(字节数据)
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //5.得到一个输出流，准备将 bytes 写入到磁盘文件
        String FilePath = "e:\\" + n + ".mp4";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FilePath));
        bos.write(bytes);

        //5.关闭相关的流
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端下载完毕，退出..");
    }
}
