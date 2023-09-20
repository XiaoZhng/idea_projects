package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formbean.NoteForm;
import service.NoteService;
import service.TagService;
@WebServlet("/author/SaveNoteServlet.tran")
public class SaveNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteForm noteForm = (NoteForm)request.getAttribute("noteForm");
		NoteService noteService = new NoteService();
		int noteID = noteService.saveNote(noteForm);
		TagService tagService = new TagService();
		tagService.saveTag(noteForm, noteID);
		List<String> msgs = new ArrayList<String>();
		msgs.add("笔记以及笔记标签添加成功");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath() + "/FetchAllNoteServlet.tran");
	}
}