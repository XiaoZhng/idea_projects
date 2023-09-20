package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TagService;
@WebServlet("/author/FetchAllTagNameServlet.tran")
public class FetchAllTagNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TagService tagService = new TagService();
		List<String> tagNameList = tagService.fetchTagNameList();
		request.setAttribute("tagNameList", tagNameList);
		request.getRequestDispatcher("/IndexServlet.tran?url=/author/tagNameList.jsp")
		.forward(request, response);
	}
}