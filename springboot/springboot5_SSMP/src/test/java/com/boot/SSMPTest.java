package com.boot;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.Book;
import com.boot.dao.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alonso
 */
@SpringBootTest
public class SSMPTest {

    @Autowired
    private BookDAO bookDAO;

    @Test
    public void testById(){
        System.out.println(bookDAO.selectById(2));
    }

    @Test
    public void testGetAll(){
        bookDAO.selectList(null);
    }

    @Test
    public void testInsert(){
        Book book = new Book();
        book.setName("sql");
        book.setType("sql1");
        book.setAuthor("sql作者1");
        System.out.println(bookDAO.insert(book));
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setName("php");
        book.setType("php1");
        book.setAuthor("php作者1");
        book.setId(8);
        System.out.println(bookDAO.updateById(book));
    }

    @Test
    public void testDelete(){
        System.out.println(bookDAO.deleteById(8));
    }

    @Test
    public void testGetPage(){
        IPage iPage = new Page(2, 5);
        IPage page = bookDAO.selectPage(iPage, null);
        System.out.println("当前页码Current= " + page.getCurrent());
        System.out.println("总页码Pages= " + page.getPages());
        System.out.println("本页显示的条数Size= " + page.getSize());
        System.out.println("总条数Total= " + page.getTotal());
        System.out.println("本页的所有数据Records= " + page.getRecords());
    }

    //根据条件查询
    @Test
    public void testGetBy(){
        String name = "作者1";
//        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
//        bookQueryWrapper.like("name", "java");
        //防止 column写错，可以使用 LambdaQueryWrapper来指定属性进行查询
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        //queryWrapper.like(Book::getName, name);
        //防止 name为null，查询失败，需要在 like()中进入判断条件
        //当查询条件为null时，不进行判断 SELECT id,type,name,author FROM book
        //不为null：SELECT id,type,name,author FROM book WHERE (name LIKE ?)
//        queryWrapper.like(name != null, Book::getName, name);
        queryWrapper.eq(name != null, Book::getAuthor, name);
        bookDAO.selectList(queryWrapper);
    }
}
