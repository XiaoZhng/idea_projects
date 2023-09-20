package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
@WebServlet("/CheckUserNameServlet.tran")
public class CheckUserNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		String userName = request.getParameter("userName");
		response.setContentType("text/html;charset=UTF-8");
		if(userService.isExists(userName)) {
			response.getWriter().append("<font color='red'>用户名被占用</font>");
		}else {
			response.getWriter().append("<font color='green'>用户名可用</font>");
		}
	}
}
