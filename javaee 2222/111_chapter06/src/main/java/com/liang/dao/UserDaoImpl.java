package com.liang.dao;

import com.liang.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    public boolean add(User user){
        System.out.println(user);
        return true;
    }

    @Override
    public boolean insert(User user) {
        System.out.println("添加的用户："+user);
        return true;
    }
}
