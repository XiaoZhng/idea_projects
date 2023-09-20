package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.User;
@WebFilter(filterName="PermissionFilter")
public class PermissionFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		List<String> msgs = new ArrayList<String>();
		String requestURI = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		String url = req.getParameter("url");
		url = (url==null) ? "" : url;
		Object o = session.getAttribute("user");
		if(requestURI.contains(contextPath+"/user/") || url.contains("/user/")) {
			if(o==null) {
				msgs.add("受保护资源，请先登录！");
				req.getSession().setAttribute("flashMsgs", msgs);
				res.sendRedirect(contextPath + "/IndexServlet.tran");
				return;
			}
		}
		if(requestURI.contains(contextPath+"/author/") || url.contains("/author/")) {
			if(o==null || !((User)o).getIsAuthor().equals("Y")) {
				msgs.add("受保护资源，请先登录！");
				req.getSession().setAttribute("flashMsgs", msgs);
				res.sendRedirect(contextPath + "/IndexServlet.tran");
				return;
			}
		}
		chain.doFilter(request, response);
	}
}