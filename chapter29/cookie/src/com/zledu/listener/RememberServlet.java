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
public class RememberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isOk = request.getParameter("isOk");
        //验证用户名密码
        if (username.equals("admin") && password.equals("123123")){
            //判断是否勾选记住密码
            if (isOk != null){
                //存入 cookie中
                Cookie name = new Cookie("username", username);
                Cookie value = new Cookie("password", password);
                //设置有效时间
                name.setMaxAge(7*24*60*60);
                value.setMaxAge(7*24*60*60);
                //将cookie响应到客户端
                response.addCookie(name);
                response.addCookie(value);
            }
            //验证成功才实现跳转
            response.sendRedirect(request.getContextPath() + "/test.html");
        }
    }
}
