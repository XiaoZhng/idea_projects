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
		javax.servlet.http.Part part = request.getPart("upload");//�˴�Ϊ�˼���CKEditorͼƬ�ϴ�
		response.setContentType("text/html;charset=UTF-8");
		if(part != null) {
			String fileContentType = part.getContentType();
			if(fileContentType.contains("image/")) {
				String fileName = part.getSubmittedFileName();
				if (fileName !=null && !"".equals(fileName)) {	
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					long time = System.currentTimeMillis();
					fileName = time + suffix;
					System.out.println("�ļ��ϴ�����" + picturePath + fileName);
					part.write(picturePath + fileName);
					part.delete();
					String contextPath = request.getContextPath();
					String url = contextPath + "/ShowNotePhotoServlet?fileName=" + fileName + "&" + time;
					//���ص�JSON���ݣ�Ŀ����Ϊ�˼���CKEditor�е�ͼƬ��ʾ
					String json = "{\"uploaded\":\"1\",\"url\":\"" + url + "\"}";
					response.getWriter().append(json);
				}
			}
		}
	}
}
