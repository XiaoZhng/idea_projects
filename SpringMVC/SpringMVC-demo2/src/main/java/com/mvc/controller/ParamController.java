package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author Alonso
 */
@Controller
public class ParamController {

//    @RequestMapping("/testServletAPI")
//    //形参位置的request表示当前请求
//    public String testServlet(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("username= " + username + ",password= " + password);
//        return "success";
//    }

    @RequestMapping("/testServletAPI")
    public String testServlet(String username, String password, HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        System.out.println("username= " + username + ",password= " + password);
        return "success";
    }

    //若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型和字符串数组接收此请求参数
    //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
    @RequestMapping("/testParam")
    //若形参与请求参数的名称不一致，则无法构成映射关系，直接为null
    public String testParam(
            //@RequestParam：将请求参数与控制器方法的形参构成映射关系
            //value：指定为形参赋值的请求参数的参数名
            //required：设置是否必须传输此请求参数，默认值为true
            //defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值
            @RequestParam(value = "user_name", required = false, defaultValue = "hh") String username,
            String password,
            String[] hobby,
            //@RequestHeader是将请求头信息和控制器方法的形参创建映射关系
            @RequestHeader(value = "Host") String host,
            //@CookieValue是将cookie数据和控制器方法的形参创建映射关系
            @CookieValue(value = "JSESSIONID") String JSESSIONID){
        System.out.println("username= " + username + ",password= " + password + ",hobby= " + Arrays.toString(hobby));
        System.out.println("host= " + host);
        System.out.println("JSESSIONID= " + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }

}
