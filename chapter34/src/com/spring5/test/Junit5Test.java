package com.spring5.test;


import com.spring5.nullable.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


/**
 * @author Alonso
 */

//使用一个复合注解替代上面两个注解完成整合
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class Junit5Test {

    @Autowired
    private Book book = new Book();

    @Test
    public void test1(){
        book.read();
    }

}
