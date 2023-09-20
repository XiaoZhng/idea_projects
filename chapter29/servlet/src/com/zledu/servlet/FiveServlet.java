package com.zledu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author Alonso
 */
public class FiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.通过 HttpServletRequest对象获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter  ("password");
        //对于多个名字相同的请求参数，需要使用 request.getParameterValues("");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username= " + username + ",password= " + password + ",hobby= " + Arrays.toString(hobbies));
        //2.请求转发
        //request.getRequestDispatcher("/success.html").forward(request, response);
        //3.通过 response 响应客户端信息
        //设置相应的信息内容格式，规定浏览器解码的编码格式，若不设置会出现中文乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //writer.write("hello");
        //writer.write("<h1>你好hello</h1>");
        //4.重定向
        //response.sendRedirect("success.html");
        //response.sendRedirect("WEB-INF/webinfo.html");
        //请求转发是从服务器跳转的，重定向是从浏览器跳转的
        request.getRequestDispatcher("/WEB-INF/webinfo.html").forward(request, response);
    }
}
