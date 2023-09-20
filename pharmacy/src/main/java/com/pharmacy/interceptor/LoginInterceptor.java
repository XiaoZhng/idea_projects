package com.pharmacy.interceptor;

import com.pharmacy.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author Alonso
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String url = request.getRequestURI();
        if(user!=null) return true;
        request.getRequestDispatcher("/login").forward(request,response);
        System.out.println("user= " + user);
        System.out.println("==========已拦截未登录请求============");
        return false;
    }
}
