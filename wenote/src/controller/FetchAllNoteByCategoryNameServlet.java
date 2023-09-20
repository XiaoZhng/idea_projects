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
@WebServlet("/FetchAllNoteByCategoryNameServlet.tran")
public class FetchAllNoteByCategoryNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String categoryName = request.getParameter("categoryName");
if(categoryName==null) categoryName = "";
		NoteService noteService = new NoteService();
		List<Note> noteListByCategoryName = noteService.fetchAllNoteByCategoryName(categoryName);
		request.setAttribute("noteList", noteListByCategoryName);
		List<String> msgs = new ArrayList<String>();
		msgs.add("按类别名称："+categoryName+"，检索笔记页面");
		request.getSession().setAttribute("flashMsgs", msgs);
		request.getRequestDispatcher("/IndexServlet.tran?url=noteList.jsp").forward(request, response);
	}
}