package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) {
        System.out.println("insert()...");
        return 1;
    }
}
