package service;

import java.util.List;
import java.util.Map;

import bean.Note;
import dao.TagDAO;
import formbean.NoteForm;

public class TagService {
	public Map<String,Integer> fetchTagNameAndNoteNum(){
		TagDAO tagDAO = new TagDAO();
		return tagDAO.selectTagNameAndNoteNum();
	}
	public List<String> fetchTagNameList(){
		TagDAO tagDAO = new TagDAO();
		return tagDAO.selectAllTagName();
	}
	public void saveTag(NoteForm noteForm,int noteID) {
		TagDAO tagDAO = new TagDAO();
		for(String tagName: noteForm.getTagNameList()) {
			tagName = tagName.trim();
			if(!"".equals(tagName)) {
				tagDAO.insert(tagName,noteID);
			}
		}
	}
	public List<String> fetchTagNameListByNoteID(int noteID){
		TagDAO tagDAO = new TagDAO();
		return tagDAO.selectTagNameListByNoteID(noteID);
	}
	public void deleteTagByNoteID(int noteID) {
		TagDAO tagDAO = new TagDAO();
		tagDAO.deleteTagByNoteID(noteID);
	}
	public void changeTagName(String oldTagName,String tagName) {
		TagDAO tagDAO = new TagDAO();
		tagDAO.updateTagName(oldTagName,tagName);
	}
}
