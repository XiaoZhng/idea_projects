package com.zledu.service.impl;

import com.zledu.bean.User;
import com.zledu.dao.UserDAO;
import com.zledu.dao.impl.UserDAOImpl;
import com.zledu.service.UserService;


/**
 * @author Alonso
 */
public class UserServiceImpl implements UserService {

    //private UserDAO userDAO = new UserDAOImpl();//向上转型
    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    @Override
    public boolean registUser(User user) {
        //先通过数据库检查用户信息
        User userBySQL = userDAO.checkUsername(user.getUsername());
        //判断是否被注册
        if (userBySQL == null){
            //成功，实现注册
            userDAO.registUser(user);
            return true;
        }else {
            //失败
            return false;
        }
    }
}
