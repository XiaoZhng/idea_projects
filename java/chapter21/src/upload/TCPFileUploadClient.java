package upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Alonso
 * 文件上传的客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //连接服务端(ip， 端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端 socket= " + socket.getClass());
        //发送一张图片(e:\\img1.png)
        //String FilePath = "e:\\img1.png";
        String FilePath = "e:\\素材视频.mp4";
        Thread.sleep(5000);
        //先 outStream写入，再OutputStream 写出
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FilePath));

        //bytes 就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过 socket获取到输出流，将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //将文件对应的字节数组的内容，写入到数据通道
        bos.write(bytes);
        socket.shutdownOutput();

        //接收服务端的“收到图片”
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        //使用 StreamUtils类方法
//        InputStream inputStream = socket.getInputStream();
//        String s1 = StreamUtils.streamToString(inputStream);
//        System.out.println(s1);

        //关闭相关流
        br.close();
        bos.close();
        socket.close();
        bis.close();
    }
}
