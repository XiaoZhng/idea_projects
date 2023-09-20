package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import util.ConnectionSharing;
import util.DBUtil;

public class UserDAO {
	public boolean selectByUserName(String userName) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where userName=?";
		boolean flag = false;
		boolean isExists = false;		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				isExists = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return isExists;
	}
	public void insert(User user) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "insert into users values(?,?,?,?,default,default,?,null)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getNickName());
			ps.setString(3, user.getTwiceMD5Password());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getBrief());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public User selectByUserNameAndPassword(String userName,String password) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where userName=? and password=?";
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString("userName"));
				user.setBrief(rs.getString("brief"));
				user.setCreateTime(rs.getString("createTime"));
				user.setIsAuthor(rs.getString("isAuthor"));
				user.setNickName(rs.getString("nickName"));
				user.setPhoto(rs.getString("photo"));
				user.setTelephone(rs.getString("telephone"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return user;
	}
	public void updateUserPhoto(String userName,String fileName) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "update users set photo=? where userName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, fileName);
			ps.setString(2, userName);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public int updatePassword(String userName,String oldPassword,String newPassword) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "update users set password=? where userName=? and password=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, userName);
			ps.setString(3, oldPassword);
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
}
