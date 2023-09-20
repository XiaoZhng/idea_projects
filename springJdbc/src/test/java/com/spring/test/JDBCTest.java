package com.spring.test;

import com.spring.config.JdbcConfig;
import com.spring.dao.AccountDao;
import com.spring.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTest {

    @Test
    public void testExecute(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "create table account (" +
                "id int primary key auto_increment," +
                "username varchar(32) not null," +
                "balance double not null)";
        jdbcTemplate.execute(sql);
        System.out.println("运行成功...");
    }

    @Test
    public void testAddAccount(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        AccountDao accountDao = context.getBean(AccountDao.class);
        Account account = new Account();
        account.setUsername("lucy");
        account.setBalance(300.1);
        accountDao.addAccount(account);
    }

    @Test
    public void testUpdateAccount(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        AccountDao accountDao = context.getBean(AccountDao.class);
        Account account = new Account();
        account.setId(1);
        account.setUsername("tom");
        account.setBalance(1000.2);
        accountDao.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        AccountDao accountDao = context.getBean(AccountDao.class);
        accountDao.deleteAccount(1);
    }

    @Test
    public void testGetAllAccount(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        AccountDao accountDao = context.getBean(AccountDao.class);
        System.out.println(accountDao.getAllAccount());
    }
}
