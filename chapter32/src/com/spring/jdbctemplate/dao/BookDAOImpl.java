package com.spring.jdbctemplate.dao;

import com.spring.jdbctemplate.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alonso
 */
@Repository
public class BookDAOImpl implements BookDAO{
    //注入 jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加
    @Override
    public void addBook(Book book) {

        String sql = "insert into book values(null, ?, ?)";
        jdbcTemplate.update(sql, book.getName(), book.getPrice());
        Book book1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), book.getId());
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        int[] ints = jdbcTemplate.batchUpdate(sql, new ArrayList<>());
    }

    //修改
    @Override
    public void updateBook(Book book) {

        String sql = "update book set name = ?, price = ? where id = ?";
        jdbcTemplate.update(sql, book.getName(), book.getPrice(), book.getId());
    }

    //删除
    @Override
    public void deleteBook(String id) {

        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, id);
    }

    //查询返回某个值
    @Override
    public int selectCount() {

        String sql = "select count(*) from book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    //查询返回对象
    @Override
    public Book selectBook(Integer id) {

        String sql = "select * from book where id = ?";
        Book book1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book1;
    }

    //查询返回集合
    @Override
    public List<Book> selectBookList() {
        
        String sql = "select * from book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    //批量添加
    @Override
    public void batchAdd(List<Object[]> batch) {

        String sql = "insert into book values(null, ?, ?)";
        jdbcTemplate.batchUpdate(sql, batch);
    }

    //批量修改
    @Override
    public void batchUpdate(List<Object[]> batch) {

        String sql = "update book set name = ?, price = ? where id = ?";
        jdbcTemplate.batchUpdate(sql, batch);
    }

    //批量删除
    @Override
    public void batchDelete(List<Object[]> batch) {

        String sql = "delete from book where id = ?";
        jdbcTemplate.batchUpdate(sql, batch);
    }

}
