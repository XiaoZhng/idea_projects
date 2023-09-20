package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wenote?autoReconnect=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8",
					"root", "root");
			System.out.println("�������ݿ����Ӷ���" + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				System.out.println("�رյ�Ԥ����SQL����ǣ�" + ps);
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				System.out.println("�رյ����ݿ����Ӷ����ǣ�" + con);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}