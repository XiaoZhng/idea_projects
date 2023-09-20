package service;

import java.util.List;
import java.util.Map;

import bean.Note;
import dao.NoteDAO;
import formbean.NoteForm;

public class NoteService {
	public Map<String,Integer> fetchCategoryNameAndNoteNum(){
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectCategoryNameAndNoteNum();
	}
	public List<Note> fetchALLNote(){
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectAllNote();
	}
	public List<String> fetchCategoryNameList(){
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectCategoryNameList();
	}
	public int saveNote(NoteForm noteForm) {
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.insert(noteForm);
	}
	public void increaseVisit(int noteID) {
		NoteDAO noteDAO = new NoteDAO();
		noteDAO.updateVisit(noteID);
	}
	public Note fetchNoteByNoteID(int noteID) {
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectByNoteID(noteID);
	}
	public Note fetchNextOrLastByNoteID(int noteID,String flag){
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectNextOrLastByNoteID(noteID, flag);
	}
	public void changeNote(Note note){
		NoteDAO noteDAO = new NoteDAO();
		noteDAO.updateNote(note);
	}
	public void deleteNoteByNoteID(int noteID) {
		NoteDAO noteDAO = new NoteDAO();
		noteDAO.deleteNoteByNoteID(noteID);
	}
	public List<Note> fetchAllNoteByKeyword(String keyword) {
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectAllNoteByKeyword(keyword);
	}
	public void changeCategoryName(String oldCategoryName,String categoryName) {
		NoteDAO noteDAO = new NoteDAO();
		noteDAO.updateCategoryName(oldCategoryName,categoryName);
	}
	public List<Note> fetchAllNoteByCategoryName(String categoryName) {
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectAllNoteByCategoryName(categoryName);
	}
	public List<Note> fetchAllNoteByTagName(String tagName) {
		NoteDAO noteDAO = new NoteDAO();
		return noteDAO.selectAllNoteByTagName(tagName);
	}
}
