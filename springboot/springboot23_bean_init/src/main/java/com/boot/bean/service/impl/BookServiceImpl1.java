package com.boot.bean.service.impl;

import com.boot.bean.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service("bookService")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check() {
        System.out.println("BookServiceImpl1...");
    }
}
