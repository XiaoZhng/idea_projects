package com.zledu.jdbc.batch_;

import com.zledu.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Alonso
 * 演示 JDBC批处理
 */
public class batch_ {

    //没有使用批处理方式
    @Test
    public void NotBatch() throws SQLException {

        //创建连接
        Connection connection = JDBCUtils.getConnection();

        //组织sql
        String sql = "insert into admin2 values(?, ?)";
        //得到预处理preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行=====");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("没有使用批处理 耗时= " + (end - start));//没有使用批处理 耗时= 7359
        //关闭资源
        JDBCUtils.close(null, preparedStatement, connection);

    }

    //使用批处理方式
    @Test
    public void batch() throws SQLException {

        //创建连接
        Connection connection = JDBCUtils.getConnection();

        //组织sql
        String sql = "insert into admin2 values(?, ?)";
        //得到预处理preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行=====");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "123");
            //将sql语句 加入到批处理包中 -> 看源码
            /*
                阅读源码：
                //1.第一次就创建 ArrayList -> 存放在 elementData的Object[]中
                //2.elementData -> Object[] 就会存放我们预处理的sql语句
                //3.当 elementData满后，就按照1.5倍扩容
                //4.当添加到指定的值后，就 executeBatch
                //5.批量处理会减少我们发送sql语句的网络开销，而且减少编译次数，因此效率提高
                (1) mysql-connector-java.jar 的底层源码
                    public void addBatch() throws SQLException {
                        try {
                            synchronized(this.checkClosed().getConnectionMutex()) {
                                QueryBindings<?> queryBindings = ((PreparedQuery)this.query).getQueryBindings();
                                queryBindings.checkAllParametersSet();
                                this.query.addBatch(queryBindings.clone());
                            }
                        } catch (CJException var6) {
                            throw SQLExceptionsMapping.translateException(var6, this.getExceptionInterceptor());
                        }
                    }
                (2)
                    public void addBatch(Object batch) {
                        if (this.batchedArgs == null) {
                            this.batchedArgs = new ArrayList();
                        }

                        this.batchedArgs.add(batch);
                    }
                (3)：mysql-connector-java-5.1.37-bin.jar 的底层源码
                     public void addBatch() throws SQLException {
                        synchronized(this.checkClosed().getConnectionMutex()) {
                            if (this.batchedArgs == null) {
                                this.batchedArgs = new ArrayList();
                            }

                            for(int i = 0; i < this.parameterValues.length; ++i) {
                                this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                            }

                            this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                        }
                    }
             */

            preparedStatement.addBatch();
            //当有1000条记录时，就批量执行
            if ((i + 1) % 1000 == 0){
                preparedStatement.executeBatch();
                //清空
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("使用批处理 耗时= " + (end - start));//使用批处理 耗时= 110
        //关闭资源
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
