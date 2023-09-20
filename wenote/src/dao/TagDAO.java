package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ConnectionSharing;
import util.DBUtil;

public class TagDAO {
	public Map<String,Integer> selectTagNameAndNoteNum(){
		Map<String,Integer> tagNameMap = new HashMap<String,Integer>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select tagName,count(*) num from tag join note on tag.noteID=note.noteID group by tagName";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tagNameMap.put(rs.getString("tagName"), rs.getInt("num"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return tagNameMap;
	}
	public List<String> selectAllTagName(){
		List<String> tagNameList = new ArrayList<String>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select distinct tagName from tag";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tagNameList.add(rs.getString("tagName"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return tagNameList;
	}
	public void insert(String tagName,int noteID) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "insert into tag values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tagName);
			ps.setInt(2, noteID);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public List<String> selectTagNameListByNoteID(int noteID){
		List<String> tagNameList = new ArrayList<String>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select tagName from tag where noteID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, noteID);
			rs = ps.executeQuery();
			while (rs.next()) {
				tagNameList.add(rs.getString("tagName"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return tagNameList;
	}
	public void deleteTagByNoteID(int noteID) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "delete from tag where noteID=?";
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
	public void updateTagName(String oldTagName,String tagName) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "update tag set tagName=? where tagName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tagName);
			ps.setString(2, oldTagName);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	
}
