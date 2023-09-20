package com.zledu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 */
public class FirstServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext servletContext = servletConfig.getServletContext();
        Object testServlet = servletContext.getAttribute("testServlet");
        System.out.println("整个项目的范围中共享数据= " + testServlet);
        String testContentPath = servletContext.getInitParameter("TestContentPath");
        System.out.println("当前工程的初始化参数= " + testContentPath);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("FirstServlet处理请求");
        //转发，实现页面跳转
        servletRequest.getRequestDispatcher("/success.html").forward(servletRequest, servletResponse);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
