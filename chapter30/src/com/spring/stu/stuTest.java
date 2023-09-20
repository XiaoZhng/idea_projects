package com.spring.stu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Alonso
 */
public class stuTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        stu array = context.getBean("array", stu.class);
        array.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Book book = context.getBean("book", Book.class);
        book.add();
    }
}
