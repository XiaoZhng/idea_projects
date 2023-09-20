package com.liang.Service;

import com.liang.dao.UserDao;
import com.liang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    public boolean add(User user){
        return userDao.add(user);
    }

//    @Resource
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
}
