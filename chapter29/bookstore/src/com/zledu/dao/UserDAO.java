package com.zledu.dao;

import com.zledu.bean.User;

/**
 * @author Alonso
 */
public interface UserDAO {

    /**
     * 通过用户名和密码查询用户信息
     */
    User login(String username, String password);

    /**
     * 通过用户名查询用户信息(校验用户名是否已被注册)
     */
    User checkUsername(String username);

    /**
     * 实现注册功能
     */
    void registUser(User user);
}
