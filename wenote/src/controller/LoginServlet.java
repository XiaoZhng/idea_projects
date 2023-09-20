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

import formbean.UserForm;
import bean.User;
import service.UserService;
@WebServlet("/LoginServlet.tran")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserForm userForm = (UserForm)request.getAttribute("userForm");
		UserService userService = new UserService();
		String userName = userForm.getUserName();
		Cookie[] cookies = request.getCookies();
		String onceMD5Password = "";
		String twiceMD5Password = "";
		boolean autoLogin = false;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("password")) {
				onceMD5Password = userForm.getPassword();
				twiceMD5Password = userForm.getOnceMD5Password();
				autoLogin = true;
			} 
		}
		if(!autoLogin) {
			onceMD5Password = userForm.getOnceMD5Password();
			twiceMD5Password = userForm.getTwiceMD5Password();
		}
		List<String> msgs = new ArrayList<String>();
		User user = userService.login(userName,twiceMD5Password);
		if(user != null) {
			Cookie cookieUserName = new Cookie("userName",userName);
			Cookie cookiePassword = new Cookie("password",onceMD5Password);
			if("on".equals(userForm.getAutoLogin())) {
				cookieUserName.setPath(request.getContextPath());
				cookiePassword.setPath(request.getContextPath());
				cookieUserName.setMaxAge(30*24*3600);
				cookiePassword.setMaxAge(30*24*3600);
			} else {
				cookieUserName.setPath(request.getContextPath());
				cookiePassword.setPath(request.getContextPath());
				cookieUserName.setMaxAge(0);
				cookiePassword.setMaxAge(0);
			}
			response.addCookie(cookieUserName);
			response.addCookie(cookiePassword);
			request.getSession().setAttribute("user", user);
			msgs.add("��¼�ɹ���");
		} else {
			Cookie cookiePassword = new Cookie("password","");
			cookiePassword.setMaxAge(0);
			response.addCookie(cookiePassword);
			msgs.add("��¼ʧ�ܣ�");
		}
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath()+"/IndexServlet.tran");
	}
}
