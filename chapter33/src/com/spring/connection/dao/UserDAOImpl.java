package com.spring.connection.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Alonso
 */
@Repository
public class UserDAOImpl implements UserDAO{
    //注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addMoney() {
        String sql = "update account set money = money + ? where name = ?";
        jdbcTemplate.update(sql, 100, "jack");
    }
    @Override
    public void reduceMoney() {
        String sql = "update account set money = money - ? where name = ?";
        jdbcTemplate.update(sql, 100, "tom");
    }
}
