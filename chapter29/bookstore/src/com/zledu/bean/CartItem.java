package com.zledu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Alonso
 * 表示 购物项的类
 */
public class CartItem implements Serializable {
    //购物项所对应的图书信息
    private Book book;
    //购物项所对应的图书数量
    private Integer count;
    //购物项所对应的图书价格
    private Double amount;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        BigDecimal bigDecimal1 = new BigDecimal(book.getPrice() + "");
        BigDecimal bigDecimal2 = new BigDecimal(count + "");
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);
        return multiply.doubleValue();
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
