package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import formbean.UserForm;
import service.UserService;
@WebServlet("/user/ChangePasswordServlet.tran")
public class ChangePasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserForm userForm = (UserForm) request.getAttribute("userForm");
		UserService userService = new UserService();
		User user = (User) request.getSession().getAttribute("user");
		String userName = user.getUserName();
		List<String> msgs = new ArrayList<String>();
		String contextPath = request.getContextPath();
		int count = 0;
		count = userService.changePassword(userName, 
userForm.getTwiceMD5PasswordOfOldPassword(),userForm.getTwiceMD5Password());
		if(count>0) {
			request.getSession().invalidate();
			msgs.add("密码修改成功！请重新登录！");
			Cookie cookiePassword = new Cookie("password", "");
			cookiePassword.setPath(request.getContextPath());
			cookiePassword.setMaxAge(0);
			response.addCookie(cookiePassword);
			request.getSession().setAttribute("flashMsgs", msgs);
			response.sendRedirect(contextPath + "/IndexServlet.tran");
		} else {
			msgs.add("密码修改失败！请重新修改！");
			request.getSession().setAttribute("flashMsgs", msgs);
			response.sendRedirect(request.getHeader("referer"));
		}	
	}
}