package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import formbean.UserForm;
@WebFilter(filterName="UserFormValidatorFilter")
public class UserFormValidatorFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		UserForm userForm = new UserForm();
		userForm.setUserName(req.getParameter("userName"));
		userForm.setOldPassword(req.getParameter("oldPassword"));	
		userForm.setNickName(req.getParameter("nickName"));
		userForm.setPassword(req.getParameter("password"));
		userForm.setConfirmPassword(req.getParameter("confirmPassword"));
		userForm.setTelephone(req.getParameter("telephone"));
		userForm.setCheckCodeInput(req.getParameter("checkCodeInput"));
		userForm.setCheckCodeSession((String)session.getAttribute("checkCodeSession"));
		userForm.setBrief(req.getParameter("brief"));
		if("on".equals(req.getParameter("autoLogin"))) {
			userForm.setAutoLogin("on");
		} else {
			userForm.setAutoLogin("off");
		}
		if(userForm.validate().size()>0) {
			session.setAttribute("flashMsgs", userForm.validate());
			session.setAttribute("userForm", userForm);
			res.sendRedirect(req.getHeader("referer"));
		} else {
			req.setAttribute("userForm", userForm);
			chain.doFilter(req, res);
		}	
	}
}
