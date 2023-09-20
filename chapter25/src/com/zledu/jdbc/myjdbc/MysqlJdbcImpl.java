package com.zledu.jdbc.myjdbc;

/**
 * @author Alonso
 * 模拟 mysql 数据库实现了jdbc接口 [mysql厂商开发]
 */
public class MysqlJdbcImpl implements Jdbcinterface{
    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 连接");
    }
}
