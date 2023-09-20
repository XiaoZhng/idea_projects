import java.io.IOException;

/**
 * @author Alonso
 */
public class TestPathServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //request.getRequestDispatcher("/test/test.html").forward(request, response);
        //request.getContextPath() 获取的是工程名
        response.sendRedirect(request.getContextPath() + "/test/test.html");
    }
}
