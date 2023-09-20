package com.spring.jdbctemplate.service;

import com.spring.jdbctemplate.bean.Book;
import com.spring.jdbctemplate.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Alonso
 */
@Service
public class BookService {
    //注入DAO
    @Autowired
    private BookDAO bookDAO;

    //添加
    public void addBook(Book book){
        bookDAO.addBook(book);
    }

    //修改
    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }

    //删除
    public void deleteBook(String id){
        bookDAO.deleteBook(id);
    }

    //查询返回某个值
    public int selectCount(){
        return bookDAO.selectCount();
    }

    //查询返回对象
    public Book selectBook(Integer id){
        return bookDAO.selectBook(id);
    }

    //查询返回集合
    public List<Book> selectBookList(){
        return bookDAO.selectBookList();
    }

    //批量添加
    public void batchAdd(List<Object[]> batch){
        bookDAO.batchAdd(batch);
    }

    //批量修改
    public void batchUpdate(List<Object[]> batch){
        bookDAO.batchUpdate(batch);
    }

    //批量删除
    public void batchDelete(List<Object[]> batch){
        bookDAO.batchDelete(batch);
    }

}
