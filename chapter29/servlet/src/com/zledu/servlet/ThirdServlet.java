package com.zledu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 */
public class ThirdServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //通过 servletConfig对象获取此servlet的友好名称
        String servletName = servletConfig.getServletName();
        System.out.println("servlet的友好名称= " + servletName);
        //通过 servletConfig对象获取此servlet的初始化参数
        String testThirdServlet = servletConfig.getInitParameter("TestThirdServlet");
        System.out.println("servlet的初始化参数= " + testThirdServlet);
        //通过 servletConfig对象获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        //通过 ServletContext获取当前工程的上下文路径
        String contextPath = servletContext.getContextPath();
        System.out.println("当前工程的上下文路径= " + contextPath);
        /**
         * 通过 ServletContext获取当前工程的编译路径
         * 若设置参数为空字符串，则获取当前工程的遍历路径
         * D:\idea_projects\chapter29\out\artifacts\servlet_war_exploded\
         * 若设置一个非空字符串，则获取当前工程的遍历路径下，字符串所对应的目录路径
         * String realPath = servletContext.getRealPath("test");
         * 结果为：D:\idea_projects\chapter29\out\artifacts\servlet_war_exploded\test
         */
        String realPath = servletContext.getRealPath("test");
        System.out.println("当前工程的编译路径= " + realPath);
        //可以在整个项目的范围中共享数据
        servletContext.setAttribute("testServlet", "hello");
        //通过 ServletContext获取当前工程的初始化参数
        String testContentPath = servletContext.getInitParameter("TestContentPath");
        System.out.println("当前工程的初始化参数= " + testContentPath);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
