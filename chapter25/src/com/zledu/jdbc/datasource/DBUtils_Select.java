package com.zledu.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Alonso
 */
public class DBUtils_Select {

    //使用apache-DBUtils 工具类 + druid 完成对表的crud操作
    @Test
    public void testQueryMany() throws SQLException {

        //1.得到 连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用 DBUtils 类和接口，先引入DBUtils 相关的jar，加入到项目的lib
        //3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.可以执行相关的方法，返回ArrayList 结果集
        String sql = "select * from actor where id >= ?";
        //解读：
        /**
         * (1) query：方法就是执行sql 语句，得到resultSet -> 封装到 -> ArrayList 集合中
         * (2) 返回集合
         * (3) connection：连接
         * (4) sql：执行的sql语句
         * (5) new BeanListHandler<>(Actor.class)：在将 resultSet -> Actor对象 -> 封装到 ArrayList
         *     底层使用反射机制 去获取Actor 类的属性，然后进行封装
         * (6) 1：就是给 sql语句中的 ? 赋值，可以有多个值，因为是可变参数Object...params
         * (7) 底层得到 resultSet，会在 query关闭，关闭 PreparedStatement
         */
        /*
            阅读源码：queryRunner.query方法
            public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
                PreparedStatement stmt = null;//定义PreparedStatement
                ResultSet rs = null;//接收返回的 ResultSet
                Object result = null;//返回 ArrayList

                try {
                    stmt = this.prepareStatement(conn, sql);//创建PreparedStatement
                    this.fillStatement(stmt, params);//对 sql 进行 ? 赋值
                    rs = this.wrap(stmt.executeQuery());//执行sql，返回resultSet
                    result = rsh.handle(rs);//返回的resultSet -> ArrayList[result] [使用到反射，对传入class对象操作]
                } catch (SQLException var33) {
                    this.rethrow(var33, sql, params);
                } finally {
                    try {
                        this.close(rs);//关闭 resultSet
                    } finally {
                        this.close((Statement)stmt);//关闭 PreparedStatement对象
                    }
                }

                return result;
            }
         */
        List<Actor> query =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合信息:");
        for (Actor actor : query){
            System.out.println(actor);
        }
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {

        //1.得到 连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用 DBUtils 类和接口，先引入DBUtils 相关的jar，加入到项目的lib
        //3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.可以执行相关的方法，返回单行记录(单个对象)
        String sql = "select * from actor where id = ?";
        //因为返回的是单行记录(单个对象)，使用的 Hander 是 BeanHandler
        Actor query =
                queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(query);

        //关闭资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成 查询结果是单行单列记录-返回的就是object
    @Test
    public void testQueryScalar() throws SQLException {

        //1.得到 连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用 DBUtils 类和接口，先引入DBUtils 相关的jar，加入到项目的lib
        //3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.可以执行相关的方法，返回单行单列
        String sql = "select name from actor where id = ?";
        //因为返回的是一个对象，使用的hander 就是 ScalarHandler
        Object query = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(query);

        //关闭资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成 dml操作(update, insert, delete)
    @Test
    public void testDML() throws SQLException {

        //1.得到 连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用 DBUtils 类和接口，先引入DBUtils 相关的jar，加入到项目的lib
        //3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.组织sql 完成 update, insert, delete
        //String sql = "update actor set name = ? where id = ?";
        //String sql = "insert into actor values(null, ?, ?, ?, ?)";
        String sql = "delete from actor where id = ?";

        //(1) 执行dml操作是使用 queryRunner.update()
        //(2) 返回的值是受影响的操作 (affected：受影响)
        //int affectedRow = queryRunner.update(connection, sql, "king",  "男", "2020-01-01", "23456");
        int affectedRow = queryRunner.update(connection, sql, 1 );
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响表");

        //关闭资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    public void test(){
        String a = "7";
        int b = 2;
        int c = 2;
        Double oD = 5.4;
        System.out.println(b+c+a);
    }
}
