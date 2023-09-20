package com.zledu.listener;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alonso
 */
public class TestCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie1 = new Cookie("username", "admin");
        Cookie cookie2 = new Cookie("password", "123456");
        //设置cookie的有效时间
        //cookie1.setMaxAge(60*60);
        //设置cookie的有效路径
        cookie1.setPath(request.getContextPath() + "/test/login.jsp");
        //将cookie响应到客户端
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        request.getRequestDispatcher("/test.html").forward(request, response);


    }
}
