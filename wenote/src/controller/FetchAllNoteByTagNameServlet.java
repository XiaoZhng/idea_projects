package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Note;
import service.NoteService;
@WebServlet("/FetchAllNoteByTagNameServlet.tran")
public class FetchAllNoteByTagNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tagName = request.getParameter("tagName");
		if(tagName==null) tagName = "";
		NoteService noteService = new NoteService();
		List<Note> noteListByTagName = noteService.fetchAllNoteByTagName(tagName);
		request.setAttribute("noteList", noteListByTagName);
		List<String> msgs = new ArrayList<String>();
		msgs.add("按标签名称："+ tagName +"，检索笔记页面");
		request.getSession().setAttribute("flashMsgs", msgs);
		request.getRequestDispatcher("/IndexServlet.tran?url=noteList.jsp").forward(request, response);
	}
}