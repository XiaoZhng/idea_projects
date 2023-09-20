package com.zledu.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Alonso
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
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

        //得到statement
        Statement statement = connection.createStatement();
        //sql语句
        String sql = "select * from news";
        //执行给定的sql语句，该语句返回单个 ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);

        //使用while取出数据
        while (resultSet.next()){ //让光标向后移动，如果没有更多行，则返回false
            int id = resultSet.getInt(1); //获取改行的第1列
            String content = resultSet.getString(2); //获取改行的第2列
            System.out.println(id + "\t" + content);

        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
