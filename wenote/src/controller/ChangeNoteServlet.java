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
@WebServlet("/author/ChangeNoteServlet.tran")
public class ChangeNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteForm noteForm = (NoteForm)request.getAttribute("noteForm");
		NoteService noteService = new NoteService();
		TagService tagService = new TagService();
		noteService.changeNote(noteForm);
		tagService.deleteTagByNoteID(noteForm.getNoteID());
		tagService.saveTag(noteForm, noteForm.getNoteID());
		List<String> msgs = new ArrayList<String>();
		msgs.add("ÐÞ¸Ä³É¹¦");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath() + "/ReadNoteServlet.tran?noteID="+noteForm.getNoteID());
	}
}
