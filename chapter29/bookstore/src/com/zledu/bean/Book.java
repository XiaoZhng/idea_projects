package com.zledu.bean;

import java.io.Serializable;

/**
 * @author Alonso
 */
public class Book implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";

    public Book() {
    }

    //图片地址有默认参数，所以不用传参
    public Book(Integer id, String title, String author, Double price, Integer sales, Integer stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
