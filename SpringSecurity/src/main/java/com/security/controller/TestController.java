package com.security.controller;

import com.security.entity.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "hello jack";
    }

    @GetMapping("index")
    public String index(){
        return "hello index";
    }

//    @GetMapping("userLogin")
//    public String userLogin(){
//        return "static/userLogin";
//    }

    @GetMapping("update")
    //@Secured({"ROLE_sale", "ROLE_admin"})
    //@PreAuthorize("hasAnyAuthority('admin')")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String update(){
        System.out.println("update...");
        return "hello update";
    }

    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admin')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> list(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(11, "admin1", "1111"));
        list.add(new Users(22, "admin2", "2222"));
        System.out.println(list);
        return list;
    }

    @GetMapping("getPreFilter")
    @PreAuthorize("hasAnyAuthority('admin')")
    //@PreFilter()
    public List<Users> getPreFilter(){
        ArrayList<Users> list = new ArrayList<>();
        list.forEach(t-> System.out.println(t.getId()+ "\t" + t.getUsername()) );
        return list;
    }
}
