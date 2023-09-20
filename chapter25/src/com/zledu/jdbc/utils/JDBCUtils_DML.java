package com.zledu.jdbc.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Alonso
 * 演示如何使用 JDBCUtils工具类，完成dml操作
 */
public class JDBCUtils_DML {

    @Test
    public void DMLTest(){

        //1.得到连接
        Connection connection = null;

        //2.组织sql
        String sql = "update actor set name = ? where id = ?";

        //3.得到 PreparedStatement
        PreparedStatement preparedStatement = null;
        try {
            //因为连接操作可能会抛出异常，所有放入try-catch捕获
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "lucy");
            preparedStatement.setInt(2, 1);
            int i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
