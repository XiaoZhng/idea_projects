import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 * servlet 跳转
 */
public class servlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获取servletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        Object text = servletContext.getAttribute("text");
        System.out.println("servletContext对象中共享的数据=" + text);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //处理请求和做出相应
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet处理请求");
        //请求转发，实现页面跳转
        servletRequest.getRequestDispatcher("/success.html").forward(servletRequest, servletResponse);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
