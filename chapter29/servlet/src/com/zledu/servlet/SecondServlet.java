package com.zledu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 */
public class SecondServlet implements Servlet {

    public SecondServlet() {
        System.out.println("SecondServlet 实例化");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("SecondServlet 初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("SecondServlet 服务");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("SecondServlet 销毁");
    }
}
