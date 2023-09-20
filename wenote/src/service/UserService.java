package service;

import bean.User;
import dao.UserDAO;

public class UserService {
	public boolean isExists(String userName) {
		UserDAO userDAO = new UserDAO();
		return userDAO.selectByUserName(userName);
	}
	public void register(User user) {
		UserDAO userDAO = new UserDAO();
		if(!userDAO.selectByUserName(user.getUserName())) {
			userDAO.insert(user);
		}
	}
	public User login(String userName,String password) {
		UserDAO userDAO = new UserDAO();
		return userDAO.selectByUserNameAndPassword(userName,password);
	}
	public void changeUserPhoto(String userName,String fileName) {
		UserDAO userDAO = new UserDAO();
		userDAO.updateUserPhoto(userName,fileName);
	}
	public int changePassword(String userName,String oldPassword,String newPassword) {
		UserDAO userDAO = new UserDAO();
		return userDAO.updatePassword(userName,oldPassword,newPassword);
	}
}
