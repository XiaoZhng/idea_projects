package com.zledu.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Alonso
 * 演示 C3P0的使用
 */
public class C3P0_ {

    //方式1：相关参数，在程序中指定user，url，password等
    @Test
    public void testC3P0_01() throws Exception {

        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件 mysql.properties 获取相关连接信息
        //通过properties获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //3.给数据源 comboPooledDataSource 设置相关的参数
        //注意：连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置数据源的初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //数据源最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        long start = System.currentTimeMillis();
        System.out.println("开始执行===");
        for (int i = 0; i < 5000; i++) {
            //getConnection()：这个方法就是 DataSource 接口实现的
            Connection connection = comboPooledDataSource.getConnection();
            //comboPooledDataSource.setBreakAfterAcquireFailure(false);
            //System.out.println("连接成功..");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0完成时间= " + (end - start));//C3P0完成时间= 609

    }

    //方式2：使用配置文件模板来完成
    //1.将 c3p0 提供的 c3p0—config.xml 拷贝到 src目录下
    //2.该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_02() throws SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("zl_edu");
        long start = System.currentTimeMillis();
        System.out.println("开始执行==");
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //System.out.println("连接成功..");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //c3p0第二种方式完成时间= 505
        System.out.println("c3p0第二种方式完成时间= " + (end - start));//1450
    }
}
