package udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Alonso
 * 发送端B
 */
public class UDPReceiverB {
    public static void main(String[] args) throws IOException {
        //1.创建一个 DatagramSocket 对象，准备在9998发送、接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        //2.将需要发送的数据，封装到 DatagramPacket 对象
        byte[] bytes = "hello china".getBytes();
        DatagramPacket packet =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.99.109.215"), 9999);

        //3.发送
        socket.send(packet);

        //4.接收A端发送的数据
        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);
        System.out.println("B端 等待接收数据");
        socket.receive(packet1);

        //5.将接收到的数据包，进行拆包，导出数据
        byte[] data = packet1.getData();
        int length = packet1.getLength();
        String s = new String(data, 0, length);
        System.out.println(s);

        //6.关闭资源
        socket.close();
        System.out.println("B端 退出..");
    }
}
