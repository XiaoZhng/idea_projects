package service;

import dao.CommentDAO;
import formbean.CommentForm;

import java.util.List;

import bean.Comment;
public class CommentService {
	public List<Comment> fetchCommentListByNoteID(int noteID){
		CommentDAO commentDAO = new CommentDAO();
		return commentDAO.selectCommentListByNoteID(noteID);
	}
	public void deleteCommentByNoteID(int noteID) {
		CommentDAO commentDAO = new CommentDAO();
		commentDAO.deleteCommentByNoteID(noteID);
	}
	public void saveComment(CommentForm commentForm) {
		CommentDAO commentDAO = new CommentDAO();
		commentDAO.insert(commentForm);
	}
	public List<Comment> fetchCommentListByUserName(String userName){
		CommentDAO commentDAO = new CommentDAO();
		return commentDAO.selectCommentListByUserName(userName);
	}
}
