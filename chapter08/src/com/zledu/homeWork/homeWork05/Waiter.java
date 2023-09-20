package com.zledu.homeWork.homeWork05;

//服务生类 子类
public class Waiter extends Person{
    public Waiter(String name, double salary, int month) {
        super(name, salary, month);
    }

    //重写服务生全年工资方法
    @Override
    public void printSal() {
        System.out.print("服务生 ");
        super.printSal(); //复用printSal()
    }
}
