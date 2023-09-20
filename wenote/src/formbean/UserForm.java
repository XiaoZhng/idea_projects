package formbean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import bean.User;

public class UserForm extends User{
	private String confirmPassword;
	private String oldPassword;
	private String autoLogin;
	private String checkCodeInput;
	private String checkCodeSession;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}
	public String getCheckCodeInput() {
		return checkCodeInput;
	}
	public void setCheckCodeInput(String checkCodeInput) {
		this.checkCodeInput = checkCodeInput;
	}
	public String getCheckCodeSession() {
		return checkCodeSession;
	}
	public void setCheckCodeSession(String checkCodeSession) {
		this.checkCodeSession = checkCodeSession;
	}
	public List<String> validate() {
		List<String> msgs = new ArrayList<String>();
		if(userName != null) {
			if(userName.trim().length() > 20 || userName.trim().length() < 6 ){
				msgs.add("�û�������6-20λ");
			}
			java.util.regex.Pattern p = java.util.regex.Pattern.compile("[\u4e00-\u9fa5]");
			java.util.regex.Matcher m = p.matcher(userName);
	        if(m.find()) {
	        	msgs.add("�û������ܰ��������ַ�");
	        }
		}
		if(nickName != null) {
			if(nickName.trim().length() > 10 || nickName.trim().length() < 2 ){
				msgs.add("�ǳƳ���2-10λ");
			}
		}
		if(password != null) {
			if(password.trim().length() > 32 || password.trim().length() < 6 ){
				msgs.add("���볤��6-32λ");
			}
		}
		if(confirmPassword != null) {
			if(confirmPassword.trim().length() > 32 || confirmPassword.trim().length() < 6 ){
				msgs.add("ȷ�����볤��6-32λ");
			}
		}
		if(confirmPassword != null && !confirmPassword.equals(password)) {
			msgs.add("�����ȷ���������һ��");
		}		
		if(telephone != null) {
			java.util.regex.Pattern p = java.util.regex.Pattern.compile("^1[345789]\\d{9}$");
			java.util.regex.Matcher m = p.matcher(telephone.trim());
			if(!m.matches()) {
				msgs.add("��ȷ���ֻ������ʽ��ȷ");
			}
		}
		if(brief != null) {
			if(brief.trim().length() > 24){
				msgs.add("���˼�鲻�ܳ���24�ַ�");
			}
		}
		if(checkCodeInput != null) {
			if(!checkCodeInput.equalsIgnoreCase(checkCodeSession)) {
				msgs.add("��֤�����");
			}
		}
		if(oldPassword != null) {
			if(oldPassword.trim().length() > 32 || oldPassword.trim().length() < 6 ){
				msgs.add("�����볤��6-32λ");
			}
		}
		return msgs;
	}
	public String getTwiceMD5PasswordOfOldPassword() {
        try {           
            MessageDigest md5 = MessageDigest.getInstance("MD5");        
            md5.update(oldPassword.getBytes());  
            String first = new BigInteger(1, md5.digest()).toString(16);
            md5 = MessageDigest.getInstance("MD5");        
            md5.update(first.getBytes());  
            String second = new BigInteger(1, md5.digest()).toString(16);
            return second;
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
}
