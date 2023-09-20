package com.spring.dao.impl;

import com.spring.dao.AccountDao;
import com.spring.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addAccount(Account account) {
        String sql = "insert into account (username, balance) " +
                "values(?, ?)";
        jdbcTemplate.update(sql, account.getUsername(), account.getBalance());
        return 0;
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set username = ?, balance = ? where id = ?";
        jdbcTemplate.update(sql, account.getUsername(), account.getBalance(), account.getId());
        return 0;
    }

    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }

    @Override
    public List<Account> getAllAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}
