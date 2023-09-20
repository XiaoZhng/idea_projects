package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Alonso
 * 客户端(字节流)
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路：
        //1.连接服务端(ip， 端口)
        //解读：连接本机的 9999端口，如果连接成功，返回 Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//InetAddress.getLocalHost() 本机ip地址
        System.out.println("客户端 socket= " + socket.getClass());
        //2.连接上后，生成socket，通过sockte.getOutputStream()
        //  得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到数据通道
        outputStream.write("hello serve".getBytes());
        //设置一个结束标记
        socket.shutdownOutput();
        //添加需求：接收服务端发送 hello,client的数据
        //思路：
        //socket.getInPutStream()
        InputStream inputStream = socket.getInputStream();
        //读取数据通道的数据,显示
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, readLen));
        }
        //关闭socket和io
        inputStream.close();

        //4.关闭流对象和socket，必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
