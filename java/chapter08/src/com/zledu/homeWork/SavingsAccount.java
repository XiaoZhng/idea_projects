package com.zledu.homeWork;

/**
 * 拓展前一个练习的BanKAccount类
 * 前类SavingsAccount每个月都有利息产生(earnMonthlyInterest)方法被调用
 * 并且有每月三次面手续费的存款和取款，在earnMonthlyInterest方法中重置交易计数
 */

public class SavingsAccount extends BankAccount{
    //分析：新增加属性
    private int count = 3; //手续费
    private double rate = 0.01; //利率

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) { //存款
        //判断是否可以免手续费
        if(count > 0){
            super.deposit(amount);
        }else{
            super.deposit(amount - 1); //1块钱转入银行账号
        }
        count--; //手续费减一次
    }

    @Override
    public void withdraw(double amount) { //取款
        //判断是否可以免手续费
        if(count > 0){
            super.withdraw(amount);
        }else{
            super.withdraw(amount + 1); //1块钱转入银行账号
        }
        count--;//手续费减一次
    }

    public void earnMonthlyInterest(){ //利率计算
        count = 3; //重置交易计数
        super.deposit(getBalance() * rate);
    }
}
