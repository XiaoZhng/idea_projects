package com.zledu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Alonso
 * 基于Druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource dataSource;

    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //编写 Connection方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //编写 close方法
    //关闭连接，在数据库连接池技术中，close 不是针对断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){

        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
