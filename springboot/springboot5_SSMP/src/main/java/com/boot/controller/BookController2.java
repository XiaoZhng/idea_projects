package com.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.bean.Book;
import com.boot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alonso
 */
//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    //查询全部
    @GetMapping
    public List<Book> getAllBook(){
        return bookService.list();
    }

    //查询单个对象
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    //添加,@RequestBody 传入的对象都是 json数据
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);
    }

    //修改
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    //分页
    @GetMapping("{currentPage}/{size}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int PageSize, Book book){
        return bookService.getPage(currentPage, PageSize, book);
    }
}
