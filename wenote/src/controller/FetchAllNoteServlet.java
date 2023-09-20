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
@WebServlet("/FetchAllNoteServlet.tran")
public class FetchAllNoteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteService noteService = new NoteService();
		List<Note> noteList = noteService.fetchALLNote();
		request.setAttribute("noteList", noteList);
		request.getRequestDispatcher("/IndexServlet.tran?url=noteList.jsp").forward(request, response);
	}
}