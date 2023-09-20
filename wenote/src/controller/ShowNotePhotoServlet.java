package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowNotePhotoServlet")
public class ShowNotePhotoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
        String path=this.getServletContext().getRealPath("resources/note/"+fileName);
        java.io.File file = new java.io.File(path);
        java.io.FileInputStream fis = new java.io.FileInputStream(file);
        String mime = request.getServletContext().getMimeType(fileName);
        if (mime == null) {    
        	mime = "application/octet-stream";
        }
        response.setContentType(mime);
        response.setContentLength((int)file.length());	        
        javax.servlet.ServletOutputStream sos = response.getOutputStream();
        byte[] bytes = new byte[1024*4];
        int len = 0;
        while( (len = fis.read(bytes))!=-1 ) {
        	sos.write(bytes, 0, len);
        }
        fis.close();
        sos.close();
	}
}