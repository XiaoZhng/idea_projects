package com.zledu.service.impl;

import com.zledu.bean.Book;
import com.zledu.dao.BookDAO;
import com.zledu.dao.impl.BookDAOImpl;
import com.zledu.service.BookService;

import java.util.List;

/**
 * @author Alonso
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public Integer getBookCountByPrice(Integer min, Integer max) {
        return bookDAO.getBookCountByPrice(min, max);
    }

    @Override
    public List<Book> getBookByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize) {
        return bookDAO.getBookByPrice(min, max, pageNo, pageSize);
    }

    @Override
    public Integer getCount() {
        return bookDAO.getCount();
    }

    @Override
    public List<Book> getBookPage(Integer pageNo, Integer pageSize) {
        return bookDAO.getBookPage(pageNo, pageSize);
    }

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBook(String id) {
        bookDAO.deleteBook(id);
    }

    @Override
    public Book getBookById(String id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }
}
