package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NoteService;
import service.TagService;
@WebServlet("/IndexServlet.tran")
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteService noteService = new NoteService();
		TagService tagService = new TagService();
		request.setAttribute("categoryNameMap", noteService.fetchCategoryNameAndNoteNum());
		request.setAttribute("tagNameMap",tagService.fetchTagNameAndNoteNum());
		request.getRequestDispatcher("/wenote.jsp").forward(request, response);
	}
}
