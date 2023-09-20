package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alonso
 */
@Controller
public class TestController {

    /**
     * registry.addViewController("/").setViewName("index");
     * registry.addViewController("/hello").setViewName("hello");
     * 因为在SpringMVC的配置类中已经配置了 index和 hello的视图控制器，
     * 所以控制器类可以不用设置这两个页面的映射关系
     */

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

//    @RequestMapping("/hello")
//    public String hello(){
//        return "hello";
//    }

    /**
     * <a th:href="@{/testException}">测试异常</a>
     * 通过页面的a链接与 error()映射，如果方法处理业务逻辑有异常，
     * 则被mvc配置类的异常处理器捕获，跳转到 视图名称为 error的页面
     * properties.setProperty("java.lang.ArithmeticException", "error");
     * <h1 th:text="${exception}"></h1>
     * 而 error页面的异常信息是从 异常处理器共享到请求域中获取
     * simpleMappingExceptionResolver.setExceptionAttribute("exception");
     *
     * 如果方法处理业务逻辑没有异常，则返回指定视图名称页面
     *  System.out.println(10/2);
     *  return "hello";
     * @param e
     * @return
     */
    @RequestMapping("/testException")
    public String error(Exception e){
        System.out.println(10/0);
        return "hello";
    }
}
