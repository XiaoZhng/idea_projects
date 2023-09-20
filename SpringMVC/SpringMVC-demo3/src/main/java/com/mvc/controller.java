package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alonso
 */
@Controller
public class controller {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/testView")
    public String testView(){
        return "test_view";
    }
}
