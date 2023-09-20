package com.spring.connection.test;

import com.spring.connection.config.TransactionConfig;
import com.spring.connection.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Alonso
 */
public class TestAccount {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
