package com.boot.service;


import com.boot.domain.Book;

import java.util.List;

/**
 * @author Alonso
 */

public interface BookService {
    Book getById(Integer id);
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    List<Book> getAll();
}
