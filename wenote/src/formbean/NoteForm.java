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
				msgs.add("�ʼǱ��ⳤ��2-100λ");
			}
		}
		if(noteContent != null) {
			if(noteContent.trim().length() == 0 ){
				msgs.add("�ʼ����ݲ���Ϊ��");
			}
		}
		if(categoryName != null) {
			if(categoryName.trim().length() == 0 || categoryName.trim().length() > 50){
				msgs.add("�����Ϊ���ҳ��Ȳ��ܳ���50λ");
			}
		}
		if(tagNames != null) {
			if(tagNames.trim().length() == 0){
				msgs.add("��ǩ����Ϊ��");
			}
			for(String tagName:getTagNameList()) {
				if(tagName.trim().length() > 50){
					msgs.add("ÿ����ǩ���Ȳ��ܳ���50λ");
					break;
				}
			}
		}
		return msgs;
	}
}
