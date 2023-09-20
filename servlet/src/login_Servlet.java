import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alonso
 */
public class login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //通过用户输入获取用户名、密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断用户名、密码是否正确，正确就跳转到登录成功页面，否则跳转到登录页面
        if ("admin".equals(username) && "123456".equals(password)){
            //登录成功，使用重定向跳转
            response.sendRedirect("login/login_success.html");
        }else {
            //登录失败，使用转发请求跳转
            request.getRequestDispatcher("/login/login.html").forward(request, response);
        }
    }
}
