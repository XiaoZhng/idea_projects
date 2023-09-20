package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Alonso
 * 客户端
 */
public class SocketTCP01Client {
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
        //4.关闭流对象和socket，必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
