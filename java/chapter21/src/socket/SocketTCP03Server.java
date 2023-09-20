package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alonso
 * 服务端(字符流)
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //思路：
        //1.在本机的9999端口监听，等待连接
        //  细节：要求在本机没有其他服务在监听9999
        //  细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发(高并发)]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 在9999端口监听,等待连接...");
        //2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        //  如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket=" + socket.getClass());
        //3.通过socket.getInputStream()读取客户端写入的数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //4.IO读取
        String s = bufferedReader.readLine();
        System.out.println(s);

        //添加需求：服务端发送 hello,client给客户端
        //思路：
        //字节流 转换成字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //写入数据到数据通道
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，注意：要求对方使用readLine()!!!
        bufferedWriter.flush();//如果使用字符流，需要手动刷新，否则数据不会写入数据通道

        //5.关闭流对象和socket
        //bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();//关闭
        System.out.println("服务端退出...");
    }
}
