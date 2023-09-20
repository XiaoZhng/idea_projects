package com.boot.service.impl;

import com.boot.dao.BookDAO;
import com.boot.domain.Book;
import com.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public boolean save(Book book) {
        return bookDAO.insert(book) > 0;
    }
}
