package com.zledu.homeWork.homeWork05;

//农民类 子类
public class Peasant extends Person{
    public Peasant(String name, double salary, int month) {
        super(name, salary, month);
    }

    @Override
    public void printSal() {
        System.out.println("农民 " + getName() + "的全年工资=" + (getSalary() * getMonth()));
    }
}
