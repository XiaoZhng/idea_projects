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
@WebServlet("/FetchAllNoteByKeywordServlet.tran")
public class FetchAllNoteByKeywordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		NoteService noteService = new NoteService();
		List<Note> noteListByKeyword = noteService.fetchAllNoteByKeyword(keyword);
		request.setAttribute("noteList", noteListByKeyword);
		List<String> msgs = new ArrayList<String>();
		msgs.add("本页面是模糊查询页面，模糊查询关键字是：" + keyword);
		request.getSession().setAttribute("flashMsgs", msgs);
		request.getRequestDispatcher("/IndexServlet.tran?url=noteList.jsp").forward(request, response);
	}
}