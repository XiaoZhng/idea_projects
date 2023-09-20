package com.zledu.listener;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter初始化");
//        System.out.println("filter友好名称= " + filterConfig.getFilterName());//FirstFilter
//        System.out.println("filter的初始化参数= " + filterConfig.getInitParameter("FirstFilterParam"));//hello
        //获取 servletContext对象
        ServletContext servletContext = filterConfig.getServletContext();

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
        System.out.println("FirstFilter放行前");
        Chain.doFilter(request, response);//放行
        System.out.println("FirstFilter放行后");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter销毁");
    }
}
