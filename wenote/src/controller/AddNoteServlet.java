package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoteService;
import service.TagService;
@WebServlet("/author/AddNoteServlet.tran")
public class AddNoteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteService noteService = new NoteService();
		List<String> categoryNameList = noteService.fetchCategoryNameList();
		TagService tagService = new TagService();
		List<String> tagNameList = tagService.fetchTagNameList();
		request.setAttribute("categoryNameList", categoryNameList);
		request.setAttribute("tagNameList", tagNameList);
		request.getRequestDispatcher("/IndexServlet.tran?url=/author/addNote.jsp").forward(request, response);
	}
}