package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alonso
 * 服务端
 */
public class Homework01Server {
    /*
        1.使用字符流的方式，编写一个客户端程序和服务器端程序
        2.客户端发送“name”，服务器端接收到后，返回“我是nova”，nova是自己的名字
        3.客户端发送“hobby”，服务器接收到后，返回“编写java程序”
        4.不是这两个问题，回复“你说啥”
     */
    public static void main(String[] args) throws IOException {
        //1.服务器端在8855端口监听
        ServerSocket serverSocket = new ServerSocket(8855);
        //2.当没有用户连接8855端口，程序会阻塞等待
        System.out.println("服务端等待接收数据..");
        Socket socket = serverSocket.accept();
        //3.用字符流的方式接收客户端发送的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //4.IO读取
        //按要求对接收到的数据进行判断
        String s = br.readLine();
        String answer = "";
        if (s.equals("name")){
            answer = "我是nova";
        }else if (s.equals("hobby")){
            answer = "编写java程序";
        }else {
            answer = "你说啥...";
        }

        //回复给客户端信息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(answer);
        bw.newLine();
        bw.flush();

        //5.关闭流
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端结束..");
    }
}
