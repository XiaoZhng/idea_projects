package com.spring.annotation;

import com.spring.test.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Alonso
 */
public class test1 {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test2(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}
