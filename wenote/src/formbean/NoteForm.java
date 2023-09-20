package formbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean.Note;

public class NoteForm extends Note{
	private String tagNames;

	public String getTagNames() {
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}
	public List<String> getTagNameList(){
		List<String> tagNameList = Arrays.asList(tagNames.split("#"));
		return tagNameList;
	}
	public List<String> validate() {
		List<String> msgs = new ArrayList<String>();
		if(noteTitle != null) {
			if(noteTitle.trim().length() > 100 || noteTitle.trim().length() < 2 ){
				msgs.add("笔记标题长度2-100位");
			}
		}
		if(noteContent != null) {
			if(noteContent.trim().length() == 0 ){
				msgs.add("笔记内容不能为空");
			}
		}
		if(categoryName != null) {
			if(categoryName.trim().length() == 0 || categoryName.trim().length() > 50){
				msgs.add("类别不能为空且长度不能超过50位");
			}
		}
		if(tagNames != null) {
			if(tagNames.trim().length() == 0){
				msgs.add("标签不能为空");
			}
			for(String tagName:getTagNameList()) {
				if(tagName.trim().length() > 50){
					msgs.add("每个标签长度不能超过50位");
					break;
				}
			}
		}
		return msgs;
	}
}
