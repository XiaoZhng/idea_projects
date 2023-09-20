package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Alonso
 */
@Controller
public class UserController {

    //查询所有用户信息
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("获取所有用户信息");
        return "success";
    }

    //根据id查询用户信息
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("根据id查询用户信息");
        return "success";
    }

    //添加用户信息
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String setUser(String username, String password){
        System.out.println("添加用户信息");
        System.out.println("用户信息：" + username + "," + password);
        return "success";
    }

    //修改用户信息
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String insertUser(){
        System.out.println("修改用户信息");
        return "success";
    }
}
