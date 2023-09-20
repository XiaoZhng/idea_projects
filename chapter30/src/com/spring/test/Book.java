package com.spring.test;

/**
 * @author Alonso
 */
public class Book {
    private String name;
    private String author;
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void NameAuthor(){
        System.out.println(name + ":" + author);
    }
}
