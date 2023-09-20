package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Note;
import service.NoteService;
import service.TagService;
@WebServlet("/author/EditNoteServlet.tran")
public class EditNoteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noteIDString = request.getParameter("noteID");
		noteIDString = (noteIDString==null) ? "0" : noteIDString;
		int noteID = Integer.parseInt(noteIDString);
		NoteService noteService = new NoteService();
		TagService tagService = new TagService();
		Note noteForm = noteService.fetchNoteByNoteID(noteID);
		List<String> allCategoryNameList = noteService.fetchCategoryNameList();
		List<String> tagNameList = tagService.fetchTagNameListByNoteID(noteID);
		List<String> allTagNameList = tagService.fetchTagNameList();
		request.setAttribute("noteForm", noteForm);
		request.setAttribute("allCategoryNameList", allCategoryNameList);
		request.setAttribute("tagNameList", tagNameList);
		request.setAttribute("allTagNameList", allTagNameList);
		request.getRequestDispatcher("/IndexServlet.tran?url=/author/editNote.jsp").forward(request, response);
	}
}