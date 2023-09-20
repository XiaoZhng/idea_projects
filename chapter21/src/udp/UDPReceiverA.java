package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Alonso
 * UDP接收端A
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个 DatagramSocket 对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);

        //2.构建一个 DatagramPacket 对象，准备接收数据
        //放入一个bute[]和长度
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3.调用 接收方法，将通过网络传输的 DatagramPacket对象，填充到 datagramPacket对象中
        //提示：当有数据包发送到 本机的9999端口时，就会接收到数据
        //     如果没有数据包发送到 本机的9999端口，就会阻塞等待
        System.out.println("A端 等待接收数据..");
        socket.receive(packet);

        //4.当接收到 DatagramPacket对象，需要进行拆包，取出数据
        byte[] data = packet.getData();
        int length = packet.getLength();
        String s = new String(data, 0, length);
        System.out.println(s);

        //5.发送数据
        byte[] bytes = "hello world".getBytes();
        DatagramPacket packet1 =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.99.109.215"), 9998);
        socket.send(packet1);

        //6关闭资源
        socket.close();
        System.out.println("A端 退出..");
    }
}
