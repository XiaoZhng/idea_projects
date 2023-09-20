package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Alonso
 */
@Controller
public class ScopeController {

    @RequestMapping("/testScopeServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "testServletAPI");
        return "success";
    }

    //使用 ModelAndView共享数据
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //向请求域共享数据
        modelAndView.addObject("testScope", "hello, ModelAndView");
        //设置视图名称，实现页面跳转
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //使用 Model共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope", "hello,model");
        System.out.println(model.getClass().getName());//BindingAwareModelMap
        return "success";
    }

    //使用 Map共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testScope", "hello,map");
        System.out.println(map.getClass().getName());//BindingAwareModelMap
        return "success";
    }

    //使用 ModelMap共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope", "hello,modelMap");
        System.out.println(modelMap.getClass().getName());//BindingAwareModelMap
        return "success";
    }

    //使用 session向session域共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //使用 application向session域共享数据
    @RequestMapping("testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}
