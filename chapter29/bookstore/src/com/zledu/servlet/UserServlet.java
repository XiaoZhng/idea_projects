package com.zledu.servlet;

import com.zledu.bean.User;
import com.zledu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Alonso
 */
public class UserServlet extends BaseServlet {

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用 service处理业务逻辑
        UserServiceImpl userService = new UserServiceImpl();
        User UserLogin = userService.login(username, password);//用户登录信息
        //判断 User是否为null
        if (UserLogin == null) {
            //失败，使用请求转发，跳回登录页面
            //在请求域中共享提示信息
            request.setAttribute("errorMsg", "用户名或密码输入错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            //成功，使用重定向
            //获取session，在session中共享数据
            HttpSession session = request.getSession();
            session.setAttribute("user", UserLogin);
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证用户输入验证码
        String code = request.getParameter("code");
        //获取正确验证码
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("sessionCode");
        //判断
        if (code.equals(sessionCode)) {
            //验证码正确，可以注册
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            //调用 service处理业务逻辑
            UserServiceImpl userService = new UserServiceImpl();
            //把请求参数封装到 User中
            User RegistUser = new User(null, username, password, email);//注册信息
            boolean b = userService.registUser(RegistUser);
            //判断
            if (b) {
                //成功，重定向跳转到注册成功页面
                response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
                System.out.println("注册成功..");

            } else {
                //失败，请求转发到注册页面
                request.setAttribute("errorMsg", "用户名已被注册");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
                System.out.println("注册失败..");
            }
        } else {
            //验证码错误，提示错误信息，请求转发
            request.setAttribute("errorMsg", "验证码错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

    }

    /**
     * 实现用户注销功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();
        //将用户信息从 session中删除
        //session.removeAttribute("user");
        //使 session失效
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * 使用ajax实现注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist_Ajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证用户输入验证码
        String code = request.getParameter("code");
        //获取正确验证码
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("sessionCode");
        //判断
        if (code.equals(sessionCode)) {
            //验证码正确，可以注册
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            //调用 service处理业务逻辑
            UserServiceImpl userService = new UserServiceImpl();
            //把请求参数封装到 User中
            User RegistUser = new User(null, username, password, email);//注册信息
            boolean b = userService.registUser(RegistUser);
            //判断
            if (b) {
                //成功，响应到客户端一个标识success
                response.getWriter().print("success");
            } else {
                //失败，响应到客户端一个标识user
                response.getWriter().print("user");
            }
        } else {
            //验证码错误，响应到客户端一个标识code
            response.getWriter().print("code");
        }

    }
}
