package com.boot.controller;

import com.boot.domain.Book;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
@RestController
@RequestMapping("/books")
public class BookController {
//    @GetMapping
//    public String index(){
//        System.out.println("springboot...");
//        return "springboot";
//    }

    @GetMapping
    public Book book(){
        System.out.println("Book...");

        Book book = new Book();
        book.setId(1);
        book.setName("jack");
        book.setAuthor("20");
        return book;
    }
}
