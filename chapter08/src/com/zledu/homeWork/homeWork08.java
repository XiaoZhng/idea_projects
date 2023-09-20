package com.zledu.homeWork;

public class homeWork08 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000); //余额1000
//        checkingAccount.deposit(10); //存入10 余额 = 1000+9=1009 1块钱转入银行账号
//        checkingAccount.withdraw(9); //取款9 余额 = 1009-9-1=999 1块钱转入银行账号
//        System.out.println(checkingAccount.getBalance());

        //测试SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);//免手续费
        savingsAccount.deposit(100);//免手续费
        savingsAccount.deposit(100);//免手续费
        System.out.println(savingsAccount.getBalance()); //1000+300=1300
        savingsAccount.deposit(100);//要手续费
        System.out.println(savingsAccount.getBalance()); //1300+100-1=1399

        //月初，调用earnMonthlyInterest(),重置次数 加利息
        savingsAccount.earnMonthlyInterest(); //重置次数 加利息
        System.out.println(savingsAccount.getBalance()); //1399+(139980.01)=1412.99
        //取款
        savingsAccount.withdraw(100);//免手续费
        savingsAccount.withdraw(100);//免手续费
        savingsAccount.withdraw(100);//免手续费
        System.out.println(savingsAccount.getBalance()); //1412.99-300=1112.99
        savingsAccount.withdraw(100);//要手续费
        System.out.println(savingsAccount.getBalance()); //1112.99-100-1=1011.99
        //存款
        savingsAccount.deposit(100);//要手续费
        System.out.println(savingsAccount.getBalance()); //1011.99+100=1111.99-1=1110.99
    }
}
