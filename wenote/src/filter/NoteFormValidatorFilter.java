package filter;

import java.io.IOException;
import bean.User;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import formbean.NoteForm;
@WebFilter(filterName="NoteFormValidatorFilter")
public class NoteFormValidatorFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		Object o = session.getAttribute("user");
		NoteForm noteForm = new NoteForm();
		String userName = ((User)o).getUserName();
		String noteIDString = req.getParameter("noteID");
		noteIDString = noteIDString==null ? "0" : noteIDString;
		int noteID = Integer.parseInt(noteIDString);
		noteForm.setNoteID(noteID);
		noteForm.setAuthor(userName);
		noteForm.setNoteTitle(req.getParameter("noteTitle"));
		noteForm.setNoteContent(req.getParameter("noteContent"));
		noteForm.setCategoryName(req.getParameter("categoryName"));
		noteForm.setTagNames(req.getParameter("tagNames"));
		if(noteForm.validate().size()>0) {
			session.setAttribute("flashMsgs", noteForm.validate());
			session.setAttribute("noteForm", noteForm);
			res.sendRedirect(req.getHeader("referer"));
		} else {
			req.setAttribute("noteForm", noteForm);
			chain.doFilter(req, res);
		}		
	}
}