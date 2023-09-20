package com.spring.service;


import com.spring.dao.UserDAO;

/**
 * @author Alonso
 */
public class UserService {
    private UserDAO userDAO;
    //创建UserDAO类型属性，生成set方法
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void add(){
        System.out.println("UserService.add()...");
        userDAO.update();
    }
}
