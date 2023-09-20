package filter;
import bean.User;
import java.io.IOException;
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

import formbean.CommentForm;
@WebFilter(filterName="CommentFormValidatorFilter")
public class CommentFormValidatorFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		Object o = session.getAttribute("user");
		CommentForm commentForm = new CommentForm();
		String userName = ((User)o).getUserName();
		commentForm.setNoteID(Integer.parseInt(req.getParameter("noteID")));
		commentForm.setUserName(userName);
		commentForm.setCommentTitle(req.getParameter("commentTitle"));
		commentForm.setCommentContent(req.getParameter("commentContent"));
		commentForm.setRemoteIP(req.getRemoteAddr());
		if(commentForm.validate().size()>0) {
			session.setAttribute("flashMsgs", commentForm.validate());
			session.setAttribute("commentForm", commentForm);
			res.sendRedirect(req.getHeader("referer"));
		} else {
			req.setAttribute("commentForm", commentForm);
			chain.doFilter(req, res);
		}		
	}
}