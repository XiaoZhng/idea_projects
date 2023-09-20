package com.spring.jdbctemplate.test;

import com.spring.jdbctemplate.bean.Book;
import com.spring.jdbctemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alonso
 */
public class testJdbcTemplate {

    @Test
    public void teteAddBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //添加
        Book book = new Book();
        book.setName("三体");
        book.setPrice(33.3);
        bookService.addBook(book);

        //修改
//        book.setName("三体2");
//        book.setPrice(33.4);
//        book.setId(1);
//        bookService.updateBook(book);

        //删除
//        book.setId(1);
//        bookService.deleteBook(book.getId() + "");

        //查询返回某个值
//        int i = bookService.selectCount();
//        System.out.println(i);

        //查询返回对象
//        Book book1 = bookService.selectBook(2);
//        System.out.println(book1);

        //查询返回集合
//        List<Book> books = bookService.selectBookList();
//        System.out.println(books);

        //批量添加
//        List<Object[]> objects = new ArrayList<>();
//        Object[] o1 = {"jack", 20.1};
//        Object[] o2 = {"tom", 22.5};
//        Object[] o3 = {"lucy", 12.76};
//        objects.add(o1);
//        objects.add(o2);
//        objects.add(o3);
//        bookService.batchAdd(objects);

        //批量修改
//        List<Object[]> objects = new ArrayList<>();
//        Object[] o1 = {"三体1", 9.9, 3};
//        Object[] o2 = {"三体2", 66.6, 4};
//        Object[] o3 = {"三体3", 16.3, 5};
//        objects.add(o1);
//        objects.add(o2);
//        objects.add(o3);
//        bookService.batchUpdate(objects);

        //批量删除
        List<Object[]> objects = new ArrayList<>();
        Object[] o1 = {3};
        Object[] o2 = {4};
        objects.add(o1);
        objects.add(o2);
        bookService.batchDelete(objects);
    }
}
