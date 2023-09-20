package com.zledu.service;

import com.zledu.bean.User;

/**
 * @author Alonso
 */
public interface UserService {

    /**
     * 验证登录
     */
    User login(String username, String password);

    /**
     * 实现注册功能
     */
    boolean registUser(User user);
}
