package com.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alonso
 */
@Controller
public class TestController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @RequestMapping("/testException")
    public String testException(){
        System.out.println(10/0);
        return "success";
    }

}
