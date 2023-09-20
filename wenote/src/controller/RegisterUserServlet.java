package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
@WebServlet("/RegisterUserServlet.tran")
public class RegisterUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		User user = (User)request.getAttribute("userForm");
		String contextPath = request.getContextPath();
		userService.register(user);
		List<String> msgs = new ArrayList<String>();
		msgs.add("×¢²á³É¹¦");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(contextPath + "/IndexServlet.tran");
	}
}
