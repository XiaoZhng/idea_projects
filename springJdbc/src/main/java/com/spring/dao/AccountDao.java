package com.spring.dao;

import com.spring.pojo.Account;

import java.util.List;

public interface AccountDao {

    int addAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(int id);

    List<Account> getAllAccount();
}
