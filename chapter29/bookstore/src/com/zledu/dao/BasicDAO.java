package com.zledu.dao;

import com.zledu.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author Alonso
 * 开发BasicDA，是其他DAO的父类
 */
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法，针对任意的表
    public int update(String sql, Object... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //因为 JDBCUtilsByDruid中的close()中，添加了删除 ThreadLocal的方法
        //所以要把每一个方法执行完就关闭资源的操作删除，才能保证执行多表操作时，Connection对象都是同一个，实现事务操作
    }

    //返回多个对象(即查询的结果是多行)，针对任意表(List)

    /**
     *
     * @param sql sql语句
     * @param clazz 传入一个类的Class对象，比如 Actor,class
     * @param parameters 可变参数， 传入 ? 的具体的值，可以是多个
     * @return 根据Actor,class 返回对应的 ArrayList 集合
     */
    public List<T> QueryMultiply(String sql, Class<T> clazz, Object... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回单个对象(即查询的结果是单行)，针对任意表(泛型)
    public T QuerySingle(String sql, Class<T> clazz, Object... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回单个对象(即查询结果是单行单列记录)，针对任意表(Object)
    public Object QueryScalar(String sql, Object... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
