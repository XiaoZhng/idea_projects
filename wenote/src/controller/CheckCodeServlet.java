package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("image/jpeg");
		java.util.Random random = new java.util.Random();
		int checkCode = random.nextInt(9000)+1000;
		session.setAttribute("checkCodeSession", checkCode+"");
		int width = 80, height = 25;
		java.awt.image.BufferedImage image = 
		new java.awt.image.BufferedImage(width,height,java.awt.image.BufferedImage.TYPE_INT_BGR);
		java.awt.Graphics pen = image.getGraphics();
		pen.fillRect(0, 0, width, height);					
		pen.setColor(java.awt.Color.BLACK);
		pen.setFont(new java.awt.Font("¿¬Ìå",java.awt.Font.BOLD,height-5));			
		pen.drawString(checkCode+"",width/5,height-5);
		javax.imageio.ImageIO.write(image, "jpeg", response.getOutputStream());			
	}
}