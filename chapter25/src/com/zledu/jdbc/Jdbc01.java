package com.zledu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Alonso
 * 这是第一个Jdbc程序
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        //前置工作，在项目下创建文件夹 libs
        //将 mysql.jar 拷贝到该目录下，点击 add as library 加入到项目中

        //1.注册驱动
        Driver driver = new Driver();

        //2.得到连接
        /**
         * (1) jdbc:mysql:// 规定好的，表示协议，通过jdbc的方式连接mysql
         * (2) localhost 本地主机，可以是ip地址
         * (3) 3306 表示mysql监听的端口
         * (4) db01 表示连接到mysql db01的数据库
         * (5) mysql的连接本质就是前面学过的socket连接
         * ?useUnicode=true&characterEncoding=utf8
         */
        String url = "jdbc:mysql://localhost:3306/db01";
        //将用户名和密码放入properties对象中
        Properties properties = new Properties();
        //说明 user 和 password 是规定好的，后面的值根据实际情况填写
        properties.setProperty("user", "root");//用户
        properties.setProperty("password", "root");//密码

        //获取连接
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        //String sql = "insert into actor values(null, 'jack', '男', '2000-10-10', '123456')";
        //String sql = "update actor set name = 'tom' where id = 1";
        String sql = "delete from actor ";
        //拿到 createStatement，用于执行静态sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();//简单来说，statement就是执行sql语句的
        int rows = statement.executeUpdate(sql);//如果是dml语句，返回的就是影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");

        //4.关闭连接资源
        statement.close();
        connect.close();
    }
}
