package com.zledu.jdbc.utils;

import org.junit.Test;

import java.sql.*;

/**
 * @author Alonso
 * 演示如何使用 JDBCUtils工具类，完成 select操作
 */
public class JDBCUtils_Select {

    @Test
    public void SelectTest(){

        //1.得到连接
        Connection connection = null;

        //2.构建sql语句
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //3.得到PreparedStatement
        try {
            connection = JDBCUtils.getConnection();
            //class com.mysql.jdbc.JDBC4Connection
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            //4.得到resultSet结果集
            resultSet = preparedStatement.executeQuery();
            //5.循环拿到每一列的数据
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                String phone = resultSet.getString(5);
                System.out.println(id + " " +  name + " " +   sex + " " +   date + " " +   phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }

    }
}
