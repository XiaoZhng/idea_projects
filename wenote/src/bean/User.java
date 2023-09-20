package bean;

import java.math.BigInteger;
import java.security.MessageDigest;

public class User {
	protected String userName;
	protected String nickName;
	protected String password;
	protected String telephone;
	protected String photo;
	protected String isAuthor;
	protected String brief;
	protected String createTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIsAuthor() {
		return isAuthor;
	}
	public void setIsAuthor(String isAuthor) {
		this.isAuthor = isAuthor;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOnceMD5Password() {
        try {           
            MessageDigest md5 = MessageDigest.getInstance("MD5");        
            md5.update(password.getBytes());  
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	public String getTwiceMD5Password() {
        try {           
            MessageDigest md5 = MessageDigest.getInstance("MD5");        
            md5.update(getOnceMD5Password().getBytes());  
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
}
