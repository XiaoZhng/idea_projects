package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.domain.Book;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
public interface BookService{

    public boolean save(Book book);
}
