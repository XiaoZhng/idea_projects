package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@javax.servlet.annotation.MultipartConfig
@WebServlet("/author/UploadNotePhotoServlet")
public class UploadNotePhotoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pictureDIR = "/resources/note/";	
		String picturePath = request.getServletContext().getRealPath(pictureDIR);		
		javax.servlet.http.Part part = request.getPart("upload");//此处为了兼容CKEditor图片上传
		response.setContentType("text/html;charset=UTF-8");
		if(part != null) {
			String fileContentType = part.getContentType();
			if(fileContentType.contains("image/")) {
				String fileName = part.getSubmittedFileName();
				if (fileName !=null && !"".equals(fileName)) {	
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					long time = System.currentTimeMillis();
					fileName = time + suffix;
					System.out.println("文件上传到：" + picturePath + fileName);
					part.write(picturePath + fileName);
					part.delete();
					String contextPath = request.getContextPath();
					String url = contextPath + "/ShowNotePhotoServlet?fileName=" + fileName + "&" + time;
					//返回的JSON数据，目的是为了兼容CKEditor中的图片显示
					String json = "{\"uploaded\":\"1\",\"url\":\"" + url + "\"}";
					response.getWriter().append(json);
				}
			}
		}
	}
}
