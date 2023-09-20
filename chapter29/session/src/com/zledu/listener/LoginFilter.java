package com.zledu.listener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Alonso
 */
public class LoginFilter extends HttpFilter {


    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取 session对象
        HttpSession session = request.getSession();
        //获取 session域中的 user对象
        Object user = session.getAttribute("user");
        //因为是判断是否登录，所以不用进行类型转换，只需判断是否为 null即可
        if (user == null){
            //未登录
            request.setAttribute("errorMsg", "请先登录");
            //跳转回登录页
            request.getRequestDispatcher("/").forward(request, response);
        }else {
            //已登录，放行
            chain.doFilter(request, response);
        }
    }
}
