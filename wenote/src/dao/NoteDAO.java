package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Note;
import util.ConnectionSharing;
import util.DBUtil;

public class NoteDAO {
	public Map<String,Integer> selectCategoryNameAndNoteNum(){
		Map<String,Integer> categoryNameMap = new HashMap<String,Integer>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select categoryName,count(*) as num from note group by categoryName";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				categoryNameMap.put(rs.getString("categoryName"), rs.getInt("num"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return categoryNameMap;
	}
	public List<Note> selectAllNote(){
		List<Note> noteList = new ArrayList<Note>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from note order by createTime desc";
		Note note = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				note = new Note();
				note.setNoteID(rs.getInt("noteID"));
				note.setAuthor(rs.getString("author"));
				note.setNoteTitle(rs.getString("noteTitle"));
				note.setNoteContent(rs.getString("noteContent"));
				note.setVisit(rs.getInt("visit"));
				note.setCategoryName(rs.getString("categoryName"));
				note.setCreateTime(rs.getString("createTime"));
				note.setUpdateTime(rs.getString("updateTime"));
				noteList.add(note);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return noteList;
	}
	public List<String> selectCategoryNameList(){
		List<String> categoryNameList = new ArrayList<String>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select distinct categoryName from note";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				categoryNameList.add(rs.getString("categoryName"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return categoryNameList;
	}
	public int insert(Note note) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into note values(null,?,?,?,0,?,null,null)";
		int insertedID = 0;
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, note.getAuthor());
			ps.setString(2, note.getNoteTitle());
			ps.setString(3, note.getNoteContent());
			ps.setString(4, note.getCategoryName());
			ps.executeUpdate();	
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				insertedID = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return insertedID;
	}
	public void updateVisit(int noteID) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "update note set visit=visit+1 where noteID=?";
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
	public Note selectByNoteID(int noteID) {
		Note note = null;
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from note where noteID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, noteID);
			rs = ps.executeQuery();
			if (rs.next()) {
				note = new Note();
				note.setNoteID(rs.getInt("noteID"));
				note.setAuthor(rs.getString("author"));
				note.setNoteTitle(rs.getString("noteTitle"));
				note.setNoteContent(rs.getString("noteContent"));
				note.setVisit(rs.getInt("visit"));
				note.setCategoryName(rs.getString("categoryName"));
				note.setCreateTime(rs.getString("createTime"));
				note.setUpdateTime(rs.getString("updateTime"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return note;
	}
	public Note selectNextOrLastByNoteID(int noteID,String flag){
		Note note = null;
		String sql = "";
		if(">".equals(flag)) {
			sql = "select * from note where noteID>? limit 1";
		}else {
			sql = "select * from note where noteID<? limit 1";
		}
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, noteID);
			rs = ps.executeQuery();
			if(rs.next()) {
				note = new Note();
				note.setNoteID(rs.getInt("noteID"));
				note.setAuthor(rs.getString("author"));
				note.setNoteTitle(rs.getString("noteTitle"));
				note.setNoteContent(rs.getString("noteContent"));
				note.setVisit(rs.getInt("visit"));
				note.setCategoryName(rs.getString("categoryName"));
				note.setCreateTime(rs.getString("createTime"));
				note.setUpdateTime(rs.getString("updateTime"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return note;
	}
	public void updateNote(Note note) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "update note set author=?,noteTitle=?,noteContent=?,categoryName=?"
				+ ",updateTime=now() where noteID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, note.getAuthor());
			ps.setString(2, note.getNoteTitle());
			ps.setString(3, note.getNoteContent());
			ps.setString(4, note.getCategoryName());
			ps.setInt(5, note.getNoteID());
			ps.executeUpdate();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public void deleteNoteByNoteID(int noteID) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "delete from note where noteID=?";
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
	public List<Note> selectAllNoteByKeyword(String keyword){
		List<Note> noteListByKeyword = new ArrayList<Note>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from note where noteTitle like ? or noteContent like ? order by createTime desc";
		Note note = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%"); 
			ps.setString(2, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				note = new Note();
				note.setNoteID(rs.getInt("noteID"));
				note.setAuthor(rs.getString("author"));
				note.setNoteTitle(rs.getString("noteTitle"));
				note.setNoteContent(rs.getString("noteContent"));
				note.setVisit(rs.getInt("visit"));
				note.setCategoryName(rs.getString("categoryName"));
				note.setCreateTime(rs.getString("createTime"));
				note.setUpdateTime(rs.getString("updateTime"));
				noteListByKeyword.add(note);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return noteListByKeyword;
	}
	public void updateCategoryName(String oldCategoryName,String categoryName) {
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		String sql = "update note set categoryName=? where categoryName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, categoryName);
			ps.setString(2, oldCategoryName);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, null);
		}
	}
	public List<Note> selectAllNoteByCategoryName(String categoryName){
		List<Note> noteListByCategoryName = new ArrayList<Note>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from note where categoryName = ? order by createTime desc";
		Note note = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, categoryName); 
			rs = ps.executeQuery();
			while (rs.next()) {
				note = new Note();
				note.setNoteID(rs.getInt("noteID"));
				note.setAuthor(rs.getString("author"));
				note.setNoteTitle(rs.getString("noteTitle"));
				note.setNoteContent(rs.getString("noteContent"));
				note.setVisit(rs.getInt("visit"));
				note.setCategoryName(rs.getString("categoryName"));
				note.setCreateTime(rs.getString("createTime"));
				note.setUpdateTime(rs.getString("updateTime"));
				noteListByCategoryName.add(note);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return noteListByCategoryName;
	}
	public List<Note> selectAllNoteByTagName(String tagName){
		List<Note> noteListByTagName = new ArrayList<Note>();
		Connection con = ConnectionSharing.getInstance().get();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select note.noteID,author,noteTitle,noteContent,visit,categoryName"
				+ ",createTime,updateTime from note join tag "
				+ "on tag.noteID=note.noteID where tagName = ? order by createTime desc";
		Note note = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tagName); 
			rs = ps.executeQuery();
			while (rs.next()) {
				note = new Note();
				note.setNoteID(rs.getInt("noteID"));
				note.setAuthor(rs.getString("author"));
				note.setNoteTitle(rs.getString("noteTitle"));
				note.setNoteContent(rs.getString("noteContent"));
				note.setVisit(rs.getInt("visit"));
				note.setCategoryName(rs.getString("categoryName"));
				note.setCreateTime(rs.getString("createTime"));
				note.setUpdateTime(rs.getString("updateTime"));
				noteListByTagName.add(note);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(null, ps, rs);
		}
		return noteListByTagName;
	}
}
