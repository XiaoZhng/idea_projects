package com.zledu.jdbc.transaction_;

import com.zledu.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @author Alonso
 * 演示在 JDBC中控制事务，模拟转账业务
 */
public class Transaction_ {

    //没有使用事务
    @Test
    public void transactionTest1(){

        //1.得到连接
        Connection connection = null;

        //2.构建sql语句
        String sql = "update account set balane = balane - 100 where id = 1";
        String sql2 = "update account set balane = balane + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //3.得到PreparedStatement
        try {
            connection = JDBCUtils.getConnection();//默认情况下，connection是默认自动提交事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第1条sql

            int i = 1 / 0;//抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第2条sql
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //使用事务
    @Test
    public void transactionTest2(){

        //1.得到连接
        Connection connection = null;

        //2.构建sql语句
        String sql = "update account set balane = balane - 100 where id = 1";
        String sql2 = "update account set balane = balane + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //3.得到PreparedStatement
        try {
            connection = JDBCUtils.getConnection();//默认情况下，connection是默认自动提交事务
            //将 connection 设置为不自动提交事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第1条sql

            //int i = 1 / 0;//抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第2条sql
            connection.commit();//提交事务
        } catch (SQLException e) {
            //这里进行回滚，即撤销执行的sql
            //默认回滚到事务开始的状态
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
