package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
@RestController
public class BookController {

    @GetMapping
    public String index(){
        System.out.println("BookController...");
        return "BookController";
    }
}
