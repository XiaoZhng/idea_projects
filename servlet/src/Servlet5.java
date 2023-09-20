import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Alonso
 */
public class Servlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //1.通过HttpServletRequest获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //对于多个名字相同的请求参数，需要使用requestgetParameterValues("")
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username=" + username + ", password=" + password
         + ", hobby=" +  Arrays.toString(hobbies));
        //2.转发请求
        //request.getRequestDispatcher("success.html").forward(request, response);
        //3.通过response相应客户端信息
        //设置相应的信息内容格式，规定浏览器解码的编码格式，若不设置会出现中文乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //writer.write("hello");
        //writer.print("<h1>hello</h1>");
        //writer.print("<h1>你好hello</h1>");
        //4、通过response实现重定向
        //response.sendRedirect("success.html");
        //通过转发和重定向访问WEB-INF下的资源
        //转发可以访问WEB-INF下的资源，重定向不可以
        //request.getRequestDispatcher("/WEB-INF/web.html").forward(request, response);
        //response.sendRedirect("/WEB-INF/web.html");//不可以
        //转发不可以跨域访问，但是重定向可以
        //request.getRequestDispatcher("https://www.baidu.com").forward(request, response);
        response.sendRedirect("https://www.baidu.com");//可以
    }
}
