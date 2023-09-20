package com.zledu.encap;

public class AccountTest {
    public static void main(String[] args) {
        //创建Account
        Account account = new Account();
        account.setName("tim");
        account.setPwd("123456");
        account.setBalance(200);

        System.out.println("姓名=" + account.getName() + " 密码=" +account.getPwd() + " 金额=" + account.getBalance());
    }
}
