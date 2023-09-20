package com.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bean.Book;
import com.boot.dao.BookDAO;
import com.boot.service.IBookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDAO, Book> implements IBookService {
    //2.业务层的接口实现类在实现对应接口后，还需要继承 ServiceImpl<mapper接口, 实体类>类

    @Autowired
    private BookDAO bookDAO;

    private Counter counter;

    public BookServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("用户付费操作次数");
    }

    public void delete(){
        counter.increment();//自增
    }

//    @Override
//    public IPage<Book> getPage(int currentPage, int pageSize) {
//        IPage<Book> iPage = new Page<>(currentPage, pageSize);
//        bookDAO.selectPage(iPage, null);
//        return iPage;
//    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        IPage<Book> iPage = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getAuthor()), Book::getAuthor, book.getAuthor());
        bookDAO.selectPage(iPage, lqw);
        return iPage;
    }

//    public static void main(String[] args) {
//        int value = new B().getValue();
//        System.out.println(value);
//    }
//    static class A{
//        protected int value;//10->11->16->34 22x
//        public A(int v){
//            setValue(v);
//        }
//        public void setValue(int value){ //10->16
//            this.value = value;
//        }
//        public int getValue(){
//            try {
//                value++;//11->17
//                return value;//10->11->17
//            }finally {
//                this.setValue(value);//22->34
//                System.out.println(value);//22->34
//            }
//        }
//    }
//
//    static class B extends A{
//        public B(){
//            super(5);//value=10
//            setValue(getValue() - 3);//value=16
//        }
//        public void setValue(int value){//5->8->17
//            super.setValue(2 * value);
//        }
//    }
}
