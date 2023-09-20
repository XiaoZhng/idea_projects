package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alonso
 */
@Controller
public class TestView {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/testForWard")
    public String testForWard(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

}
