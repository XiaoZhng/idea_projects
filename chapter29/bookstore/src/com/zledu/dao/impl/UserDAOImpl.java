package com.zledu.dao.impl;

import com.zledu.bean.User;
import com.zledu.dao.BasicDAO;
import com.zledu.dao.UserDAO;

/**
 * @author Alonso
 */
public class UserDAOImpl extends BasicDAO<User> implements UserDAO {
    @Override
    public User login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return QuerySingle(sql, User.class, username, password);
    }

    @Override
    public User checkUsername(String username) {
        String sql = "select * from user where username = ?";
        return QuerySingle(sql, User.class, username);
    }

    @Override
    public void registUser(User user) {
        String sql = "insert into user values(null, ?, ?, ?)";
        update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
