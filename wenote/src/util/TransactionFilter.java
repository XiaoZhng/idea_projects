package util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(filterName="TransactionFilter",urlPatterns= {"*.tran"})
public class TransactionFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			ConnectionSharing.getInstance().set(con);
			chain.doFilter(request, response);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse res = (HttpServletResponse)response;
			List<String> msgs = new ArrayList<String>();
			msgs.add("操作失败，请重新操作！");
			req.getSession().setAttribute("flashMsgs", msgs);
			res.sendRedirect(req.getHeader("referer"));
		} finally {
			ConnectionSharing.getInstance().remove();
			DBUtil.close(con, null, null);
		}
	}
}