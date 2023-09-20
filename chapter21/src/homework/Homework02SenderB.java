package homework;

import java.io.IOException;
import java.net.*;

/**
 * @author Alonso
 * 发送端B
 */
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        //1.创建一个 DatagramSocket对象，发送、接收数据
        DatagramSocket socket = new DatagramSocket(8834);

        //2.将需要发送的数据，封装到 DatagramPacket 对象
        byte[] bytes = "四大名著有哪些".getBytes();
        DatagramPacket packet =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.99.109.215"), 8833);
        //发送
        socket.send(packet);

        //3.接收服务端回复的数据
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        System.out.println("B端 等待接收数据..");
        socket.receive(packet);

        //接收到数据后，拆包，把数据导出
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //3.关闭流
        socket.close();
        System.out.println("B端 退出..");
    }
}
