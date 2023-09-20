package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formbean.CommentForm;
import service.CommentService;
@WebServlet("/user/SaveCommentServlet.tran")
public class SaveCommentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentForm commentForm = (CommentForm)request.getAttribute("commentForm");
		CommentService commentService = new CommentService();
		commentService.saveComment(commentForm);
		List<String> msgs = new ArrayList<String>();
		msgs.add("评论发表成功！");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath() + "/ReadNoteServlet.tran?noteID="+commentForm.getNoteID());
	}
}