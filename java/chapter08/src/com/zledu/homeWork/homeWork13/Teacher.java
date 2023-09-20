package com.zledu.homeWork.homeWork13;

public class Teacher extends Person{
    private double work_age;

    public Teacher(String name, String sex, int age, double work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public double getWork_age() {
        return work_age;
    }

    public void setWork_age(double work_age) {
        this.work_age = work_age;
    }
    //教学的方法
    public void teach(){
        System.out.println("教师:" + getName() + "我承诺，我会认真教学");
    }
    //重写play方法
    @Override
    public String play() {
        return super.play() + "象棋";
    }
    //分析得出需要有个信息输出发方法,体现了封装
    public void printInfo_tea(){
        System.out.println("老师的信息:");
        System.out.println(super.baseInfo());
        System.out.println("工龄:" + work_age);
        teach();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}' + super.toString();
    }
}
