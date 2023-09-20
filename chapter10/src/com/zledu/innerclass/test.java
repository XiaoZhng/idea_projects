package com.zledu.innerclass;

public class test {
    public static void main(String[] args) {
        Account lll = new Account("lll", 10, "0000");
        lll.hi();
    }
}

class Account{
    private String name;
    private double salary;
    private String mima;

    public Account(String name, double salary, String mima) {
        setName(name);
        setSalary(salary);
        setMima(mima);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4){
            this.name = name;
        }else {
            System.out.println("名字长度不符");
            this.name = "张三";
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 20){
            this.salary = salary;
        }else {
            System.out.println("余额太小");
            this.salary = 100000;
        }
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        if (mima.length() == 6) {
            this.mima = mima;
        }else {
            System.out.println("密码长度不正确");
            this.mima = "123456";
        }
    }

    public void hi(){
        System.out.println("信息：name=" + name + " salary=" + salary + " mima=" + mima);
    }
}