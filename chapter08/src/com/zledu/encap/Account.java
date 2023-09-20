package com.zledu.encap;

/**
 * 创建程序，在其中定义两个类：Account和AccountTest类体会Java的封装性
 * Account类要求具有属性：姓名(长度为2位3位4位)，余额(必须>20)
 * 密码(必须是六位)，如果不满足，则给出提示信息，并给默认值
 * 通过setXXX的方法给Account 的属性赋值
 * 在AccountTest中测试
 */

public class Account {
    //为了封装，将3个属性设置为private
    private String name;
    private String pwd;
    private double balance; //余额

    //提供两个构造器


    public Account() {
    }

    public Account(String name, String pwd, double balance) {
        this.setName(name);
        this.setPwd(pwd);
        this.setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //判定 姓名(长度为2位3位4位)
        if(name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        }else{
            System.out.println("姓名长度不正确(范围为2位3位4位)，默认值：佚名");
            this.name = "佚名";
        }
    }

    public String getPwd() {

        return pwd;
    }

    public void setPwd(String pwd) {
        //判定 密码(必须是六位)
        if(pwd.length() == 6) {
            this.pwd = pwd;
        }else{
            System.out.println("密码长度不正确(范围必须是六位)，默认值：000000");
            this.pwd = "000000";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        //判定 余额(必须>20)
        if(balance > 20) {
            this.balance = balance;
        }else{
            System.out.println("余额不正确(金额必须大于20)，默认值：0");
            this.balance = 0;
        }
    }
}
