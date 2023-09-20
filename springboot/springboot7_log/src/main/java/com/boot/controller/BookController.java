package com.boot.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    //创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String index(){
        System.out.println("hello, BookController...");
        log.info("info...");
        log.debug("debug...");
        log.warn("warn...");
        log.error("error...");

        return "hello, BookController";
    }
}
