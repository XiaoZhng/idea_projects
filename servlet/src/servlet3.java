import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alonso
 * 演示 ServletConfig
 */
public class servlet3 implements Servlet {

    //private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //this.config = config;
        //通过ServletConfig对象获取Servlet的友好名称
        String servletName = servletConfig.getServletName();
        System.out.println("servlet3的友好名称=" + servletName);//servlet3
        //通过ServletConfig对象获取servlet的初始化参数
        String test = servletConfig.getInitParameter("test");
        System.out.println("servlet3的初始化参数=" + test);//hello
        //通过ServletConfig对象获取servletContext对象
        ServletContext servletContext = servletConfig.getServletContext();

        //通过ServletContext获取当前工程的上下文路径
        String contextPath = servletContext.getContextPath();
        System.out.println("当前工程的上下文路径=" + contextPath);
        /**
         * 通过ServletContext获取当前工程的编译路径
         * 若设置参数为空字符串，则获取当前工程的编译路径
         * D:\idea_projects\javaweb\servlet\target\servlet-1.0-SNAPSHOT\
         * 若设置一个非空字符串，则获取当前工程的编译路径下，字符串所对应的目录路径
         * String realPath = servletContext.getRealPath("Test");
         * 结果为= D:\idea_projects\javaweb\servlet\target\servlet-1.0-SNAPSHOT\Test
         * */
        String realPath = servletContext.getRealPath("Test");
        System.out.println("当前工程的编译路径=" + realPath);
        //可以在整个项目的范围中共享数据
        servletContext.setAttribute("text", "hello,world");
        //通过ServletContext获取当前工程的初始化参数
        String textContext = servletContext.getInitParameter("testContext");
        System.out.println("当前工程的初始化参数=" + textContext);//你好

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
