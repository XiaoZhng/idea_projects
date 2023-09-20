package formbean;

import java.util.ArrayList;
import java.util.List;

import bean.Comment;

public class CommentForm extends Comment{
	public List<String> validate() {
		List<String> msgs = new ArrayList<String>();
		if(commentTitle != null) {
			if(commentTitle.trim().length() > 100 || commentTitle.trim().length() < 2 ){
				msgs.add("���۱��ⳤ��2-100λ");
			}
		}
		if(commentContent != null) {
			if(commentContent.trim().length() == 0 ){
				msgs.add("�������ݲ���Ϊ��");
			}
		}
		return msgs;
	}
}
