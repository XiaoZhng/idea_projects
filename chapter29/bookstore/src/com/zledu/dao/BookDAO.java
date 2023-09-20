package com.zledu.dao;

import com.zledu.bean.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alonso
 */
public interface BookDAO {

    /**
     * 更新图书的库存和销量
     */
    void updateBookSalesAndStock(Integer bookId, Integer count);

    /**
     * 根据价格区间，查询图书总计数
     */
    Integer getBookCountByPrice(Integer min, Integer max);

    /**
     * 根据价格区间，查询图书信息
     */
    List<Book> getBookByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize);

    /**
     * 获取数据库中图书的总计数
     */
    Integer getCount();

    /**
     * 根据当前页的页面 pageNo 和 每页显示的条数 pageSize 获取图书分页信息
     */
    List<Book> getBookPage(Integer pageNo, Integer pageSize);

    /**
     * 查询所有图书信息
     */
    List<Book> getBookList();

    /**
     * 添加图书
     */
    void addBook(Book book);

    /**
     * 删除图书(根据 id 删除)
     */
    void deleteBook(String id);

    /**
     * 根据图书 id 获取要修改的图书信息
     */
    Book getBookById(String id);

    /**
     * 修改图书
     */
    void updateBook(Book book);
}
