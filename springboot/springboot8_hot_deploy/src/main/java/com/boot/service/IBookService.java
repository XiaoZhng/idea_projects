package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.bean.Book;

/**
 * @author Alonso
 */
public interface IBookService extends IService<Book> {
    //1.mybatisPlus提供了快速开发业务层的操作，需要接口继承 IService类


    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
