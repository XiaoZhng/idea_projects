package com.zledu.dao.impl;

import com.zledu.bean.Book;
import com.zledu.dao.BasicDAO;
import com.zledu.dao.BookDAO;

import java.util.List;

/**
 * @author Alonso
 */
public class BookDAOImpl extends BasicDAO<Book> implements BookDAO {

    @Override
    public void updateBookSalesAndStock(Integer bookId, Integer count) {
        String sql = "update books set sales = sales + ?, stock = stock - ? where id = ?";
        update(sql, count, count, bookId);
    }

    @Override
    public Integer getBookCountByPrice(Integer min, Integer max) {
        String sql = "select count(id) from books where price between ? and ?";
        long o = (Long) QueryScalar(sql, min, max);
        return (int) o;
    }

    @Override
    public List<Book> getBookByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize) {
        String sql = "select * from books where price between ? and ? limit ?, ?";
        return QueryMultiply(sql, Book.class, min, max, pageNo, pageSize);
    }

    @Override
    public Integer getCount() {
        String sql = "select count(id) from books";
        long o = (Long) QueryScalar(sql);
        return (int) o;
    }

    @Override
    public List<Book> getBookPage(Integer pageNo, Integer pageSize) {
        String sql = "select * from books limit ?, ?";
        return QueryMultiply(sql, Book.class, (pageNo-1) * pageSize, pageSize);
    }

    @Override
    public List<Book> getBookList() {
        String sql = "select * from books";
        return QueryMultiply(sql, Book.class);
    }

    @Override
    public void addBook(Book book) {
        String sql = "insert into books values(null, ?, ?, ?, ?, ?, ?)";
        update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public void deleteBook(String id) {
        String sql = "delete from books where id = ?";
        update(sql, id);
    }

    @Override
    public Book getBookById(String id) {
        String sql = "select * from books where id = ?";
        return QuerySingle(sql, Book.class, id);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update books set title = ?, author = ?, price = ?, sales = ?, stock = ?, imgPath = ? where id = ?";
        update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }
}
