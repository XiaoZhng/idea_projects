package com.boot.app;

import com.boot.bean.service.BookService;
import com.boot.config.SpringConfig6;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alonso
 */
public class App6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig6.class);
        BookService book = context.getBean("bookService", BookService.class);
        book.check();
    }
}
