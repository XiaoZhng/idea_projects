package upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alonso
 * 文件上传的服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //服务端在8888端口监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端 在8888端口监听,等待连接...");
        //当没有客户端连接9999端口时，程序会阻塞，等待连接
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket= " + socket.getClass());
        //服务端接收 客户端发送的图片
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        //String destPath = "src\\qie.png";
        String destPath = "src\\素材视频.mp4";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        bos.write(bytes);

        //向客户端恢复“收到图片”
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();//把内容刷新到数据通道
        socket.shutdownOutput();//设置写入结束标记

        //关闭相应流
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
