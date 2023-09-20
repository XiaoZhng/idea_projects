package com.zledu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alonso
 */
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //获取用户输入的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断
        if (username.equals("admin") && password.equals("123456")){
            //成功
            response.sendRedirect(request.getContextPath() + "/login/loginSuccess.html");
        }else {
            //失败
            request.getRequestDispatcher("/login/login.html").forward(request, response);
        }
    }
}
