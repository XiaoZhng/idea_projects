package com.zledu.homeWork.homeWork05;

//科学家类 子类
public class Scientist extends Person{
    //特定属性 年终奖
    private double bonus;

    public Scientist(String name, double salary, int month) {
        super(name, salary, month);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    //重写科学家全年工资方法
    @Override
    public void printSal() {
        System.out.println("科学家 " + getName() + "的全年工资=" + (getSalary() * getMonth() + bonus));
    }
}
