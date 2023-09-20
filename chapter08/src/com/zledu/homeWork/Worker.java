package com.zledu.homeWork;

public class Worker extends Employee{
    public Worker(String name, double daySal, int dayWork, double great) {
        super(name, daySal, dayWork, great);
    }
    //重写printSal()
    @Override
    public void printSal() {
        System.out.println("员工的工资");
        super.printSal();
    }
}
