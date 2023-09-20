package com.zledu.jdbc.myjdbc;

/**
 * @author Alonso
 * 模拟jdbc测试
 */
public class TestJdbc {
    public static void main(String[] args) {
        //完成对 mysql数据库的测试
        Jdbcinterface jdbcinterface = new MysqlJdbcImpl();
        jdbcinterface.getConnection();
        jdbcinterface.crud();
        jdbcinterface.close();

        System.out.println("======================");
        //完成对 Oracle数据库的测试
        jdbcinterface = new MysqlJdbcImpl();
        jdbcinterface.getConnection();
        jdbcinterface.crud();
        jdbcinterface.close();
    }
}
