import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Alonso
 * 演示 InetAddress类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机的 InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //2.根据指定主机名 获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-LR0F2UQ");
        System.out.println("host1= " + host1);//DESKTOP-LR0F2UQ/10.99.109.215

        //3.根据域名返回 InetAddress对象，比如 www.baidu.com对应
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2= " + host2);//www.baidu.com/ 183.232.231.174

        //4.通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("hostAddress= " + hostAddress);//183.232.231.174

        //5.通过 InetAddress 对象，获取对应的主机名/或者域名
        String hostName = host2.getHostName();
        System.out.println("hostName= " + hostName);//www.baidu.com
    }
}
