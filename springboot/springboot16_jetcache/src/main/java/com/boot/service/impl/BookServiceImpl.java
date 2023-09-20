package com.boot.service.impl;

import com.alicp.jetcache.anno.*;
import com.boot.dao.BookDAO;
import com.boot.domain.Book;
import com.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alonso
 * 模拟 缓存机制
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600, cacheType = CacheType.BOTH)
    //@CacheRefresh(refresh = 5)
    public Book getById(Integer id) {
        return bookDAO.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDAO.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public boolean update(Book book) {
        return bookDAO.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean delete(Integer id) {
        return bookDAO.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.selectList(null);
    }
}
