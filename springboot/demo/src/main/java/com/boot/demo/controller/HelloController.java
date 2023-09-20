package com.boot.demo.controller;

import com.boot.demo.MyDataSource;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
@RestController
public class HelloController {

    //使用yaml数据中的单一数据
    @Value("${server.port}")
    private String port;

    @Value("${user1}")
    private String user1;

    @Value("${user2.name}")
    private String user2Name;
    @Value("${user2.age}")
    private String user2Age;

    @Value("${user3[1].name}")
    private String user3Name;

    @Value("${user4[1].name}")
    private String user4Name;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir2}")
    private String tempDir2;

    //使用自动装配将所有的数据封装到一个对象Environment中
    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource myDataSource;

    @RequestMapping("/")
    public String hello(){
        System.out.println("hello,world,demo");
        System.out.println("port= " + port);
        System.out.println("user1= " + user1);
        System.out.println("user2Name= " + user2Name);
        System.out.println("user2Age= " + user2Age);
        System.out.println("user3Name= " + user3Name);
        System.out.println("user4Name= " + user4Name);
        System.out.println("tempDir= " + tempDir);
        System.out.println("tempDir2= " + tempDir2);
        System.out.println("===================");
        System.out.println(environment.getProperty("server.port"));
        System.out.println(environment.getProperty("user2.name"));
        System.out.println("====================");
        System.out.println("myDataSource= " + myDataSource);
        return "hello,world,demo";
    }
}
