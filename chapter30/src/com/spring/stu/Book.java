package com.spring.stu;

import java.util.List;

/**
 * @author Alonso
 */
public class Book {
    private List<String> bookList;
    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    public void add(){
        System.out.println(bookList);
    }
}
