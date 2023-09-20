package com.liang.controller;

import com.liang.Service.UserService;
import com.liang.dao.UserDao;
import com.liang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public boolean add(User user){
        return userService.add(user);
    }



}
