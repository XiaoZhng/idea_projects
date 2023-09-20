package com.spring5.test;

import com.spring5.nullable.Book;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Alonso
 */
public class Spring5Test {

    //函数式风格创建对象，交给 spring 进行管理
    @Test
    public void  testGenericApplicationContext(){
        //虽说创建了book对象，但是在Spring里还没有注册
//        Book book = new Book();

        //创建 GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //调用方法进行注册
        context.refresh();
        //获取 Spring注册对象
        //context.registerBean(Book.class);
        context.registerBean("book1", Book.class, () -> new Book());

        //Book book = (Book) context.getBean("com.spring5.nullable.Book");
        Book book = (Book) context.getBean("book1");

        System.out.println(book);
    }
}
