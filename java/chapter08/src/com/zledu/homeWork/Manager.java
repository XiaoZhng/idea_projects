package com.zledu.homeWork;

public class Manager extends Employee{
    //特有属性 奖金
    private double bonus;
    //因为经理奖金不是一开始就确定的，所以后面通过setBonus()确定
    public Manager(String name, double daySal, int dayWork, double great) {
        super(name, daySal, dayWork, great);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    //重写printSal()
    //因为经理的工资计算方式和Employee不一样
    @Override
    public void printSal() {
        System.out.println("经理：" + getName() + "的工资=" +
                (bonus + getDaySal() * getDayWork() * getGreat()));
    }
}
