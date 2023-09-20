package com.zledu.homeWork;

public class Employee {
    //员工属性：姓名，单日工资，工作天数
    private String name;
    private double daySal;
    private int dayWork;
    //由题目分析得出，经理和员工都有一个等级属性
    private double great;

    //方法[构造器，getter,setter]
    public Employee(String name, double daySal, int dayWork, double great) {
        this.name = name;
        this.daySal = daySal;
        this.dayWork = dayWork;
        this.great = great;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getDayWork() {
        return dayWork;
    }

    public void setDayWork(int dayWork) {
        this.dayWork = dayWork;
    }

    public double getGreat() {
        return great;
    }

    public void setGreat(double great) {
        this.great = great;
    }

    //员工方法(打印工资)
    public void printSal(){
        System.out.println(name + " 工资=" + daySal * dayWork * great);
    }
}
