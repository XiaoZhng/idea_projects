package com.zledu.homeWork.homeWork05;

//教师类 子类
public class Teacher extends Person{
    //特定属性 课酬
    private double classSal; //课酬工资
    private int classDay; //课酬天数

    public Teacher(String name, double salary, int month) {
        super(name, salary, month);
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    //重写教师全年工资方法
    @Override
    public void printSal() {
        System.out.println("教师 " + getName() + "的全年工资="
                  + (getSalary() * getMonth() + classSal * classDay));
    }
}
