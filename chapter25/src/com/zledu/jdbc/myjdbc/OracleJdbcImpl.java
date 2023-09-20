package com.zledu.jdbc.myjdbc;

/**
 * @author Alonso
 * 模拟 Oracle 数据库实现了jdbc接口 [Oracle厂商开发]
 */
public class OracleJdbcImpl implements Jdbcinterface{
    @Override
    public Object getConnection() {
        System.out.println("得到 Oracle 连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 Oracle 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 Oracle 连接");
    }
}
