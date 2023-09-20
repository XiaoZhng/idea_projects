package com.zledu.jdbc.preparedstatement_;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Alonso
 * 演示 PreparedStatement使用
 */
@SuppressWarnings("all")
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        //PreparedStatement

        //用户输入用户名和密码
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        //说明：如果希望看到sql注入效果，这里用nextLine()
        // nextLine():当收到回车就表示结束
        // next():当接收到 空格或者单引号就表示结束
        String admin_name = scanner.nextLine();
        System.out.print("请输入密码：");
        String admin_pwd = scanner.nextLine();

        //通过properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //1.注册驱动
        Class.forName(driver);//建议写上

        //2.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3.得到prepareStatement
        //3.1 组织sql，sql语句的 ? 相当于占位符
        String sql = "select * from admin where name = ? and pwd = ? ";
        //3.2 prepareStatement 对象实现了 PrepareStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ? 赋值
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);
        //4.执行 select 语句使用 executeQuery()
        //  如果执行的是dml语句(update, insert, delete) executeUpdate()
        //  这里执行 executeQuery()，不要写 sql
        ResultSet resultSet = preparedStatement.executeQuery();

        //如果查询到一条记录，则说明该用户存在
        if (resultSet.next()){
            System.out.println("登录成功..");
        }else {
            System.out.println("登录失败..");
        }

        //5.关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
