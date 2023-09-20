package com.boot.bookservice;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.Book;
import com.boot.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alonso
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    //根据id查询
    @Test
    public void testById(){
        System.out.println(bookService.getById(2));
    }

    //查询所有
    @Test
    public void testGetAll(){
        bookService.list(null);
    }

    //添加
    @Test
    public void testInsert(){
        Book book = new Book();
        book.setName("=========");
        book.setType("====");
        book.setAuthor("======作者1");
        System.out.println(bookService.save(book));
    }

    //根据id修改
    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setName("vue");
        book.setType("vue1");
        book.setAuthor("vue作者1");
        book.setId(7);
        System.out.println(bookService.updateById(book));
    }

    //删除
    @Test
    public void testDelete(){
        System.out.println(bookService.removeById(9));
    }

    //分页
    @Test
    public void testGetPage(){
        IPage iPage = new Page(1, 5);
        IPage page = bookService.page(iPage);
        System.out.println("当前页码Current= " + page.getCurrent());
        System.out.println("总页码Pages= " + page.getPages());
        System.out.println("本页显示的条数Size= " + page.getSize());
        System.out.println("总条数Total= " + page.getTotal());
        System.out.println("本页的所有数据Records= " + page.getRecords());
    }
}
