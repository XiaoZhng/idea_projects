package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Alonso
 * 客户端(字符流)
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //思路：
        //1.连接服务端(ip， 端口)
        //解读：连接本机的 9999端口，如果连接成功，返回 Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//InetAddress.getLocalHost() 本机ip地址
        System.out.println("客户端 socket= " + socket.getClass());
        //2.连接上后，生成socket，通过socket.getOutputStream()
        //  得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到数据通道
        //转换成 字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，注意：要求对方使用readLine()!!!
        bufferedWriter.flush();//如果使用字符流，需要手动刷新，否则数据不会写入数据通道
        //添加需求：接收服务端发送 hello,client的数据
        //思路：
        //字节流 转换成字符流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //读取数据通道的数据,显示
        String s = bufferedReader.readLine();
        System.out.println(s);

        //4.关闭流对象和socket，必须关闭
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
