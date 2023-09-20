package com.zledu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Alonso
 * 演示 PreparedStatement的 DML操作
 */
@SuppressWarnings("all")
public class PreparedStatement_DML {
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
        //String sql = "select * from admin where name = ? and pwd = ? ";

        //添加操作
        //String sql = "insert into admin values(?, ?)";

        //修改操作
        //String sql = "update admin set pwd = ? where name = ?";

        //删除操作
        String sql = "delete from admin where name = ?";

        //3.2 prepareStatement 对象实现了 PrepareStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ? 赋值
        preparedStatement.setString(1, admin_name);
        //preparedStatement.setString(2, admin_pwd);
        //4.执行 select 语句使用 executeUpdate()
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "操作成功" : "操作失败");

        //5.关闭资源
        preparedStatement.close();
        connection.close();
    }
}
