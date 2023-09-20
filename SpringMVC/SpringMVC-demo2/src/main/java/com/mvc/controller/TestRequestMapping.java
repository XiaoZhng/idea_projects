package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alonso
 */
@Controller
//@RequestMapping("/hello")
public class TestRequestMapping {

    @RequestMapping(
            value = {"testRequestMapping", "test"},
            //访问的前提是，请求地址必须能匹配
            //不加method请求方式，任何请求方式都允许访问
            method = {RequestMethod.POST, RequestMethod.GET}
    )
    public String success(){
        return "success";
    }

    @GetMapping("/testMapping")
    public String testGet(){
        return "success";
    }

    @PostMapping("/testMapping")
    public String testPost(){
        return "success";
    }

    //params：条件要同时满足
    @RequestMapping(value = "/testParams", params = "username")
    public String testParams(){
        return "success";
    }

    @RequestMapping(value = "/testParamsAndPassword", params = {"username", "password!=123"})
    public String testPassword(){
        return "success";
    }

    @RequestMapping(value = "testHeader", headers = "Host=localhost:8080")
    public String testHeader(){
        return "success";
    }

    //?：表示任意的单个字符
    //*：表示任意的0个或多个字符
    //**：表示任意的一层或多层目录
    //注意：在使用**时，只能使用/**/xxx的方式
    @RequestMapping("/**/aaa")
    public String testAnd(){
        return "success";
    }

    @RequestMapping("/testRest/{username}/{password}")
    public String testRest(@PathVariable("username") String username, @PathVariable("password") Integer password){
        System.out.println("username= " + username + ",password= " + password);
        return "success";
    }
}
