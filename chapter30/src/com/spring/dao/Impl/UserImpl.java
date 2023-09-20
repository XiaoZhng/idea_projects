package com.spring.dao.Impl;

import com.spring.dao.UserDAO;

/**
 * @author Alonso
 */
public class UserImpl implements UserDAO {
    @Override
    public void update() {
        System.out.println("UserImpl update()...");
    }
}
