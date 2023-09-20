package com.zledu.jdbc.datasource;

import com.zledu.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Alonso
 */
public class JDBCUtilsByDruid_select {

    @Test
    public void TestSelect(){

        //1.得到连接
        Connection connection = null;

        //2.构建sql语句
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //3.得到PreparedStatement
        try {
            connection = JDBCUtilsByDruid.getConnection();
            //class com.alibaba.druid.pool.DruidPooledConnection
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            //4.得到resultSet结果集
            resultSet = preparedStatement.executeQuery();
            //connection.close();//关闭连接
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
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }

    }

    //使用老师的土方法来解决 ResultSet -> 封装 -> ArrayList
    @Test
    public void testSelectToArrayList(){

        //1.得到连接
        Connection connection = null;

        //2.构建sql语句
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //3.得到PreparedStatement
        try {
            connection = JDBCUtilsByDruid.getConnection();
            //class com.alibaba.druid.pool.DruidPooledConnection
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            //4.得到resultSet结果集
            resultSet = preparedStatement.executeQuery();
            //connection.close();//关闭连接
            //5.循环拿到每一列的数据
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                String phone = resultSet.getString(5);
                //System.out.println(id + " " +  name + " " +   sex + " " +   date + " " +   phone);
                ArrayList<Actor> list = new ArrayList<>();//创建ArrayList
                //把得到的 resultSet结果集的记录，封装到 Actor对象，放到list集合
                list.add(new Actor(id, name, sex, date, phone));
                //System.out.println("list集合= " + list);
                for (Actor actor : list){
                    System.out.println(actor.getId() +  "\t" + actor.getName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
