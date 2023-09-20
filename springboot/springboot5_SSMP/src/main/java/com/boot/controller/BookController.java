package com.boot.controller;

import cn.bootcast.service.IpCountService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.bean.Book;
import com.boot.controller.utils.R;
import com.boot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


/**
 * @author Alonso
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    //查询全部
    @GetMapping
    public R getAllBook(){
        return new R(true, bookService.list());
    }

    //查询单个对象
    @GetMapping("/{id}")
    public R getBookById(@PathVariable Integer id){
        return new R(true, bookService.getById(id));
    }

    //添加,@RequestBody 传入的对象都是 json数据
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")){
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

    //删除
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        //监控：每次执行删除业务等同于执行了付费业务
        bookService.delete();

        return new R(bookService.removeById(id));
    }

    //修改
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    //分页
//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用总页码值作为当前页码值
//        //currentPage：当前页码值
//        //page.getPages：总页码值
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if (currentPage > page.getPages()){
//            //那么重新执行查询操作，使用总页码值作为当前页码值
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }

    @Autowired
    private IpCountService ipCountService;

    //分页，加入查询条件
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){

        ipCountService.count();
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用总页码值作为当前页码值
        //currentPage：当前页码值
        //page.getPages：总页码值
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()){
            //那么重新执行查询操作，使用总页码值作为当前页码值
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
