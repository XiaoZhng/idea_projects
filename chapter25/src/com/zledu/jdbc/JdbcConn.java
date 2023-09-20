package com.zledu.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Alonso
 */
public class JdbcConn {

    //方式一
    @Test
    public void connect01() throws SQLException {

        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=utf-8&useSSl=false&serverTimezone=GMT";
        //将用户名和密码放入properties对象中
        Properties properties = new Properties();
        //说明 user 和 password 是规定好的，后面的值根据实际情况填写
        properties.setProperty("user", "root");//用户
        properties.setProperty("password", "root");//密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式二
    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //使用反射加载Driver类，动态加载，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=utf-8&useSSl=false&serverTimezone=GMT";
        //将用户名和密码放入properties对象中
        Properties properties = new Properties();
        //说明 user 和 password 是规定好的，后面的值根据实际情况填写
        properties.setProperty("user", "root");//用户
        properties.setProperty("password", "root");//密码
        Connection connect = driver.connect(url, properties);
        System.out.println("第二种方式= " + connect);
    }

    //方式三 使用DriverManager 替代 Driver 进行统一管理，有更好的扩展性
    @Test
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        //使用反射加载 Driver
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //创建 url 和 user 和 password
        String url = "jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=utf-8&useSSl=false&serverTimezone=GMT";
        String user = "root";
        String password = "root";
        DriverManager.registerDriver(driver);//注册Driver驱动
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种方式= " + connection);
    }

    //方式四 使用Class.forName 自动完成注册驱动，简化代码
    //这种方式获取连接是使用的最多的，推荐使用
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //使用反射加载Driver类
        /**
         * 在加载Driver类时，完成注册
         * 阅读源码：
         * 1.静态代码块，在类加载时，会执行一次
         * 2.DriverManager.registerDriver(new Driver()); //完成注册
         * 3.因此注册driver的工作已经完成
         *
         * static {
         *         try {
         *             DriverManager.registerDriver(new Driver()); //完成注册
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */
        Class.forName("com.mysql.cj.jdbc.Driver"); //建议写上
        //com.mysql.cj.jdbc.Driver

        String url = "jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=utf-8&useSSl=false&serverTimezone=GMT";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第四种方式= " + connection);
    }

    //方式五：在方式四的基础上改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {

        //通过properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);//建议写上
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式五= " + connection);
    }

    //练习：使用方式五，完成数据库操作
    //1.创建news表
    //2.使用jdbc添加五条数据
    //3.修改id=1的数据
    //4.删除id=3的数据
    @Test
    public void connectTest() throws IOException, ClassNotFoundException, SQLException {

        //通过properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        //写sql语句
        //创建news表
        String sql1 = "create table news(id int not null default 0, " +
                "content varchar(32) not null default '')";
        //使用jdbc添加五条数据
        String sql2 = "insert into news values(1, '北京新闻'), (2, '广州新闻'), (3, '广西新闻'), " +
                "(4, '成都新闻'), (5, '天津新闻')";

        //修改id=1的数据
        String sql3 = "update news set content = '南宁新闻' where id = 1";

        //删除id=3的数据
        String sql4 = "delete from news where id = 3";

        Statement statement = connection.createStatement();
        //int row1 = statement.executeUpdate(sql1);
        //int row2 = statement.executeUpdate(sql2);
        //int row3 = statement.executeUpdate(sql3);
        int row4 = statement.executeUpdate(sql4);
        //System.out.println(row2);
        //executeUpdate，是判断dml语句返回行数，create语句不是dml语句，所以不会返回行数
        //System.out.println(row1 > 0 ? "成功" : "失败");
        System.out.println(row4 > 0? "成功" : "失败");

        //关闭连接
        statement.close();
        connection.close();
    }
}
