package com.boot.service.impl;

import com.boot.dao.BookDAO;
import com.boot.domain.Book;
import com.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Alonso
 * 模拟 缓存机制
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    //模拟 缓存机制
//    private HashMap<Integer, Book> cache = new HashMap<>();
//
//    @Override
//    public Book getById(Integer id) {
//        //如果当前缓存中没有要查询的数据，则进行查询，否则直接从缓存中获取数据返回
//        if (cache.get(id) == null){
//            Book book = bookDAO.selectById(id);
//            //查询到要放入cache缓存中中
//            cache.put(id, book);
//            return book;
//        }
//        return cache.get(id);
//    }

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        return bookDAO.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDAO.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDAO.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDAO.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.selectList(null);
    }
}
