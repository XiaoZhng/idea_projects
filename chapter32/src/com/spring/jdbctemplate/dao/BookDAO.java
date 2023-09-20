package com.spring.jdbctemplate.dao;

import com.spring.jdbctemplate.bean.Book;

import java.util.List;

/**
 * @author Alonso
 */
public interface BookDAO {

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String id);

    int selectCount();

    Book selectBook(Integer id);

    List<Book> selectBookList();

    void batchAdd(List<Object[]> batch);

    void batchUpdate(List<Object[]> batch);

    void batchDelete(List<Object[]> batch);
}
