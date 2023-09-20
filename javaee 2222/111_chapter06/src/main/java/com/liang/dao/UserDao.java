package com.liang.dao;

import com.liang.pojo.User;
import org.springframework.stereotype.Component;

public interface UserDao {
    boolean add(User user);
    boolean insert(User user);
}
