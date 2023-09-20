package com.zledu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Alonso
 * 根据每次请求所传输的特殊的请求参数，自动的执行相应的方法
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        String methodName = request.getParameter("method");
        //通过methodName获取方法，此方法的方法名根methodName一致
        try {
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //因为方法的访问权限是 protected  所以忽略该方法的访问权限
            method.setAccessible(true);
            //执行此方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
