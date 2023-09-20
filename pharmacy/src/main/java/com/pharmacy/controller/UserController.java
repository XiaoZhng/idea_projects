package com.pharmacy.controller;

import com.pharmacy.domain.User;
import com.pharmacy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户接口
 * @author Alonso
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 跳转到登录页
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/userLogin")
    public String userLogin(String username, String password, HttpServletRequest request, Model model){
        User user = userService.selectUser(username, password);
        if (user == null){
            return "redirect:/login";
        }
        request.getSession().setAttribute("user", user);
        return "redirect:/drugs";
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/login";
    }

}
