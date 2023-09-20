package com.zledu.mhl.service;

import com.zledu.mhl.dao.UserDAO;
import com.zledu.mhl.domain.User;

import java.util.List;

/**
 * @author Alonso
 */
public class UserService {

    //需要 UserDAO属性
    private UserDAO userDAO = new UserDAO();

    //显示餐厅所有成员和职位
    public List<User> UserList(){

        return userDAO.QueryMultiply("select login.id, login.name, employee.job from login, employee " +
                "where login.empId = employee.empId", User.class);
    }
}
