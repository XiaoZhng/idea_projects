package com.liang.dao;

import com.liang.pojo.Account;

public interface AccountDao {
    int addAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Account account);
}
