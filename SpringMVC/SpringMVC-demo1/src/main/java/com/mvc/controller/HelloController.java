package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alonso
 */
@Controller
public class HelloController {

    //@RequestMapping：处理请求和控制器方法之间的映射关系
    //value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径

    // "/" ->  /WEB-INF/templates/index.html
    @RequestMapping(value = "/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/test")
    public String hello(){
        return "test";
    }
}
