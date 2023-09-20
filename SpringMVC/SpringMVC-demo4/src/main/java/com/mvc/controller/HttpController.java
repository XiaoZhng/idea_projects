package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alonso
 */
@Controller
//@RestController
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody= " + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEntity表示整个请求报文的信息
        System.out.println("请求头= " + requestEntity.getHeaders());
        System.out.println("请求体= " + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    //加上 @ResponseBody注解，表示该方法的返回值直接作为响应报文的响应体响应到浏览器
    //不加则表示该方法的返回值作为视图名称被解析
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testresponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User("jack", 12);
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        System.out.println(username + "," + password);
        return "hello,ajax";
    }
}
