import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 * servlet 生命周期
 */
public class servlet2 implements Servlet {

    public servlet2() {
        System.out.println("servlet2===实例化");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext servletContext = servletConfig.getServletContext();
        String testContext = servletContext.getInitParameter("testContext");
        System.out.println("servlet2中的初始化参数=" + testContext);//你好
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet2===服务");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet2===销毁");
    }
}
