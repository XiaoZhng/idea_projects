package com.spring.test;

import com.spring.bean.emp;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Alonso
 */
public class Test2 {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        emp emp = context.getBean("emp", emp.class);
        emp.add();
    }
}
