package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TagService;
@WebServlet("/author/ChangeTagNameServlet.tran")
public class ChangeTagNameServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldTagName = request.getParameter("oldTagName");
		String tagName = request.getParameter("tagName");
		List<String> msgs = new ArrayList<String>();
		if(tagName != null) {
			if(tagName.trim().length() == 0 || tagName.trim().length() > 50){
				msgs.add("标签名称不能为空且长度不能超过50位");
				request.getSession().setAttribute("flashMsgs", msgs);
				response.sendRedirect(request.getHeader("referer"));
				return;
			}
		}
		TagService tagService = new TagService();
		tagService.changeTagName(oldTagName,tagName);
		msgs.add("修改成功");
		request.getSession().setAttribute("flashMsgs", msgs);
		response.sendRedirect(request.getContextPath() + "/author/FetchAllTagNameServlet.tran");
	}
}