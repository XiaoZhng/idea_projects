package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Comment;
import bean.Note;
import bean.User;
import service.CommentService;
import service.NoteService;
import service.TagService;
@WebServlet("/ReadNoteServlet.tran")
public class ReadNoteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noteIDString = request.getParameter("noteID");
		noteIDString = (noteIDString==null) ? "0" : noteIDString;
		int noteID = Integer.parseInt(noteIDString);
		NoteService noteService = new NoteService();
		TagService tagService = new TagService();
		CommentService commentService = new CommentService();
		Note note = noteService.fetchNoteByNoteID(noteID);
		Note nextNote = noteService.fetchNextOrLastByNoteID(noteID, ">");
		Note lastNote = noteService.fetchNextOrLastByNoteID(noteID, "<");
		List<String> tagNameList = tagService.fetchTagNameListByNoteID(noteID);
		List<Comment> commentList = commentService.fetchCommentListByNoteID(noteID);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String role = (user==null) ? "N" : user.getIsAuthor();
		if("N".equals(role)) {
			noteService.increaseVisit(noteID);
		}
		request.setAttribute("note", note);
		request.setAttribute("nextNote", nextNote);
		request.setAttribute("lastNote", lastNote);
		request.setAttribute("tagNameList", tagNameList);
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/IndexServlet.tran?url=readNote.jsp").forward(request, response);
	}
}