package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import service.NoteService;
import service.TagService;
@WebServlet("/author/DeleteNoteServlet.tran")
public class DeleteNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noteIDString = request.getParameter("noteID");
		noteIDString = noteIDString==null ? "0" : noteIDString;
		int noteID = Integer.parseInt(noteIDString);
		TagService tagService = new TagService();
		NoteService noteService = new NoteService();
		CommentService commentService = new CommentService();
		commentService.deleteCommentByNoteID(noteID);
		tagService.deleteTagByNoteID(noteID);
		noteService.deleteNoteByNoteID(noteID);
		List<String> msgs = new ArrayList<String>();
		msgs.add("É¾³ý³É¹¦£¡");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath() + "/FetchAllNoteServlet.tran");
	}
}