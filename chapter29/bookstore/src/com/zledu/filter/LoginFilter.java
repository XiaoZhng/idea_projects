package com.zledu.filter;

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
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            request.setAttribute("errorMsg", "结账请先的登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
