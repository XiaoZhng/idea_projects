package com.zledu.homeWork.homeWork05;

//员工类 父类
public class Person {
    //属性
    private String name;
    private double salary; //基本工资
    private int month; // 工作月份

    public Person(String name, double salary, int month) {
        this.name = name;
        this.salary = salary;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    //全年工资方法
    public void printSal(){
        System.out.println(name + "的全年工资=" + (salary * month));
    }
}
