package com.liang.dao;

import com.liang.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int addAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account) {
        return 0;
    }

    @Override
    public int deleteAccount(Account account) {
        return 0;
    }
}
