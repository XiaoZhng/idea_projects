package com.boot.controller;

import com.boot.domain.Book;
import com.boot.service.BookService;
import com.boot.service.MSGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
@RestController
@RequestMapping()
public class MSGController {

    @Autowired
    private MSGService msgService;

    @GetMapping("/{tel}")
    public String get(@PathVariable String tel){
        String code = msgService.get(tel);
        //System.out.println(book);
        return code;
    }

    @GetMapping("/{tel}/{code}")
    public boolean check(@PathVariable String tel, @PathVariable String code){
        boolean check = msgService.check(tel, code);
        return check;
    }
}
