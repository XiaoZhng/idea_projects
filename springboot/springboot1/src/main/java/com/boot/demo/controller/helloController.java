package com.boot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
//@Controller
//@ResponseBody
@RestController
public class helloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot2..";
    }
}
