package com.zledu.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Alonso
 * 演示 statement 的sql注入问题
 */
@SuppressWarnings("all")
public class Statement_ {
    public static void main(String[] args) throws Exception {

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

        //3.得到Statement
        Statement statement = connection.createStatement();

        //4.组织sql
        String sql = "select * from admin where name = '"
                + admin_name +"' and pwd = '"+ admin_pwd +"'";
        ResultSet resultSet = statement.executeQuery(sql);
        //如果查询到一条记录，则说明该用户存在
        if (resultSet.next()){
            System.out.println("登录成功..");
        }else {
            System.out.println("登录失败..");
        }

        //5.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
