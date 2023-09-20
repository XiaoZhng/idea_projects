package controller;
import bean.Comment;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.CommentService;
@WebServlet("/user/FetchMyCommentServlet.tran")
public class FetchMyCommentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService commentService = new CommentService();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userName = user.getUserName();
		List<Comment> comments = commentService.fetchCommentListByUserName(userName);
		request.setAttribute("commentList", comments);
		request.getRequestDispatcher("/IndexServlet.tran?url=user/myCommentList.jsp")
		.forward(request, response);
	}
}