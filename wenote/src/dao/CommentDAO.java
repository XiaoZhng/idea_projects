package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Comment;
import bean.User;
import util.ConnectionSharing;
import util.DBUtil;

public class CommentDAO {
	public List<Comment> selectCommentListByNoteID(int noteID){
		List<Comment> commentList = new ArrayList<Comment>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select commentID,commentTitle,commentContent,comment.createTime createTime"
					+ ",remoteIP,noteID,comment.userName userName,nickName,photo,brief "
					+ "  from comment join users on comment.userName=users.userName "
					+ "  where noteID=? order by createTime desc";
		Comment comment = null;
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, noteID);
			rs = ps.executeQuery();
			while (rs.next()) {
				comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setCommentTitle(rs.getString("commentTitle"));
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCreateTime(rs.getString("createTime"));
				comment.setRemoteIP(rs.getString("remoteIP"));
				comment.setNoteID(rs.getInt("noteID"));
				comment.setUserName(rs.getString("userName"));
				user = new User();
				user.setUserName(rs.getString("userName"));
				user.setNickName(rs.getString("nickName"));
				user.setPhoto(rs.getString("photo"));
				user.setBrief(rs.getString("brief"));
				comment.setUser(user);
				commentList.add(comment);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return commentList;
	}
	public void deleteCommentByNoteID(int noteID) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "delete from comment where noteID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, noteID);
			ps.executeUpdate();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public void insert(Comment comment) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "insert into comment values(null,?,?,?,?,?,null)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, comment.getNoteID());
			ps.setString(2, comment.getUserName());
			ps.setString(3, comment.getCommentTitle());
			ps.setString(4, comment.getCommentContent());
			ps.setString(5, comment.getRemoteIP());
			ps.executeUpdate();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public List<Comment> selectCommentListByUserName(String userName){
		List<Comment> commentList = new ArrayList<Comment>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from comment where userName=? order by createTime desc";
		Comment comment = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
				comment = new Comment();
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentID(rs.getInt("commentID"));
				comment.setCommentTitle(rs.getString("commentTitle"));
				comment.setCreateTime(rs.getString("createTime"));
				comment.setNoteID(rs.getInt("noteID"));
				comment.setRemoteIP(rs.getString("remoteIP"));
				comment.setUserName(rs.getString("userName"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return commentList;
	}
}
