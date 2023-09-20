package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Alonso
 * 接收端A
 */
public class Homework02ReceiverA {
    /*
        1.编写接收端A和发送端B，使用UDP协议完成
        2.接收端在 8833端口等待接收数据
        3.发送端向接收端 发送数据 “四大名著有哪些”
        4.接收端收到 发送端发送的问题后，返回答案，否则返回 what？
        5.接收端和发送端程序退出
     */
    public static void main(String[] args) throws IOException {
        //1.创建一个 DatagramSocket对象，准备在8833端口接收数据
        DatagramSocket socket = new DatagramSocket(8833);

        //2.创建 DatagramPacket对象，接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("A端 等待接收数据..");
        socket.receive(packet);

        //3.接收到数据后，拆包，把数据导出
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);

        //4.根据要求判断
        String answer = "";
        if (s.equals("四大名著有哪些")){
            answer = "《西游记》、《三国演义》、《红楼梦》、《水浒传》";
        }else {
            answer = "what?";
        }

        //5.回复客户端
        byte[] bytes = answer.getBytes();
        packet =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.99.109.215"), 8834);
        //发送
        socket.send(packet);

        //6.关闭流
        socket.close();
        System.out.println("A端 退出..");
    }
}
