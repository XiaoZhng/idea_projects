package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoteService;
@WebServlet("/author/ChangeCategoryNameServlet.tran")
public class ChangeCategoryNameServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldCategoryName = request.getParameter("oldCategoryName");
		String categoryName = request.getParameter("categoryName");
		List<String> msgs = new ArrayList<String>();
		if(categoryName != null) {
			if(categoryName.trim().length() == 0 || categoryName.trim().length() > 50){
				msgs.add("������Ʋ���Ϊ���ҳ��Ȳ��ܳ���50λ");
				request.getSession().setAttribute("flashMsgs", msgs);
				response.sendRedirect(request.getHeader("referer"));
				return;
			}
		}
		NoteService noteService = new NoteService();
		noteService.changeCategoryName(oldCategoryName,categoryName);
		msgs.add("�޸ĳɹ�");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath() + 
				"/author/FetchAllCategoryNameServlet.tran");
	}
}