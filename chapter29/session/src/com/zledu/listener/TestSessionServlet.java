package com.zledu.listener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * @author Alonso
 */
@WebServlet(name = "TestSessionServlet", value = "/TestSessionServlet")
public class TestSessionServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("123456")){
            //成功，重定向跳转
            user user = new user(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
