package com.zledu.filter;

import com.zledu.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Alonso
 * 该类是，处理事务过滤的类
 */
public class TransactionFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("开始事务过滤");
        Connection connection = null;
        try {
            //获取链接对象
            connection = JDBCUtilsByDruid.getConnection();
            connection.setAutoCommit(false);
            //放行，即执行servlet中的service()，实现操作的整个工程
            chain.doFilter(request, response);
            //执行到此位置，说明实现功能的过程中没有异常，需要提交事务
            connection.commit();
            System.out.println("执行成功");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            //执行到此位置，说明实现功能的过程中有异常，需要回滚事务
            try {
                connection.rollback();
                System.out.println("执行失败");
                response.sendRedirect(request.getContextPath() + "/pages/error/error.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
