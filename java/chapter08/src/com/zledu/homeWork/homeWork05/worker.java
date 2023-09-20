package com.zledu.homeWork.homeWork05;

//工人类 子类
public class worker extends Person{
    public worker(String name, double salary, int month) {
        super(name, salary, month);
    }

    //工人类重写全年工资方法
    @Override
    public void printSal() {
        System.out.println("工人 " + getName() + "的全年工资=" + (getSalary() * getMonth()));
    }
}
