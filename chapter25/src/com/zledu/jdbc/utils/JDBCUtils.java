package com.zledu.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Alonso
 * 这是一个工具类，完成JDBC的连接 和 关闭操作
 */
public class JDBCUtils {
    private static String user;//用户名
    private static String password;//密码
    private static String url;//数据库地址
    private static String driver;//驱动名

    //properties配置文件在静态代码块进行初始化
    static {
        try {
            //通过properties获取配置文件信息
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1.将编译异常转成 运行异常
            //2.调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection(){
        //这里可以不用注册驱动
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //1.将编译异常转成 运行异常
            //2.调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //关闭资源
    /*
        ResultSet 结果集
        Statement 或者 preparedStatement
        Connection
        需要关闭资源就传入对象，否则传入null
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        //判断传入的 resultSet、statement、connection 是否为空
        //如果不为空，就关闭
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
