package com.zledu.listener;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 */
public class SecondFilter implements Filter {
    public void destroy() {
        System.out.println("SecondFilter销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("SecondFilter放行前");
        chain.doFilter(req, resp);
        System.out.println("SecondFilter放行后");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("SecondFilter初始化");
    }

}
