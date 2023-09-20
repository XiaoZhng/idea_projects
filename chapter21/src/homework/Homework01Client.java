package homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Alonso
 * 客户端
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务端(ip, 端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 8855);
        //2.连接上后，用生成的socket，用输出流发送数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入问题:");
        String next = scanner.next();

        bw.write(next);
        bw.newLine();//插入换行符，表示写入结束
        bw.flush();//如果使用的是字符流，需要手动刷新，否则不会写入到数据通道

        //3.接收服务端回复的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("回复的信息===========");
        System.out.println(s);

        //3.关闭流
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端结束..");
    }
}
