package com.zledu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Alonso
 */
@SuppressWarnings("all")
public class PreparedStatementTest {
    public static void main(String[] args) throws Exception {
        //创建admin表
        //使用PreparedStatement 添加5条数据
        //修改 tom的记录，将name改成king
        //删除一条记录
        //查询全部记录，显示在控制台

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("用户名：");
//        String admin_user = scanner.next();
//        System.out.print("密码：");
//        String admin_pwd = scanner.next();

        //通过properties获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        //通过properties获取到相关值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1.注册驱动
        Class.forName(driver);

        //2.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //4.得到PreparedStatement
        //使用PreparedStatement 添加5条数据
        //String sql = "insert into admin values(?, ?)";

        //修改 tom的记录，将name改成king
        //String sql = "update admin set name = ? where name = 'tom'";

        //删除一条记录
        //String sql = "delete from admin where name = ?";

        //查询全部记录，显示在控制台
        String sql = "select * from admin";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.给 ? 赋值
        //preparedStatement.setString(1, admin_user);
        //preparedStatement.setString(2, admin_pwd);

        //6.executeUpdate()
        //int rows = preparedStatement.executeUpdate();
        //System.out.println(rows > 0 ? "操作成功" : "操作失败");

        //查询使用 executeQuery()
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString(1);//获取第1列数据
            String pwd = resultSet.getString(2);//获取第2列数据
            System.out.println(name + "\t" + pwd);
        }

        //7.关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
