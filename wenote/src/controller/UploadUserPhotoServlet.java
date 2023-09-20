package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.UserService;
@javax.servlet.annotation.MultipartConfig
@WebServlet("/user/UploadUserPhotoServlet.tran")
public class UploadUserPhotoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pictureDIR = "/resources/photo/";
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userName = user.getUserName();
		String picturePath = request.getServletContext().getRealPath(pictureDIR);		
		javax.servlet.http.Part part = request.getPart("upload");
		response.setContentType("text/html;charset=UTF-8");
		if(part != null) {
			String fileContentType = part.getContentType();
			if(fileContentType.contains("image/")) {
				String fileName = part.getSubmittedFileName();
				if (fileName !=null && !"".equals(fileName)) {	
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					long time = System.currentTimeMillis();
					fileName = userName + suffix;
					System.out.println("文件上传到：" + picturePath + fileName);
					part.write(picturePath + fileName);
					part.delete();
					String contextPath = request.getContextPath();
					String url = contextPath + "/ShowUserPhotoServlet?fileName=" + fileName + "&" + time;
					//返回的JSON数据，目的是为了兼容CKEditor中的图片显示
					String json = "{\"uploaded\":\"1\",\"url\":\"" + url + "\"}";
					user.setPhoto(fileName);
					session.setAttribute("user", user);
					UserService userService = new UserService();
					userService.changeUserPhoto(userName,fileName);
					response.getWriter().append(json);
					System.out.println("返回的JSON数据是" + json);
				}
			}
		}
	}
}