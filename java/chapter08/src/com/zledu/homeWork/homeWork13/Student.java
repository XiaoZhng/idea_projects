package com.zledu.homeWork.homeWork13;

public class Student extends Person{
    private int stu_id;

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    //学习的方法
    public void study(){
        System.out.println("学生:" + getName() + "我承诺，我会好好学习");
    }
    //重写play方法
    @Override
    public String play() {
        return super.play() + "足球";
    }
    //分析得出需要有个信息输出发方法,体现了封装
    public void printinfo_stu(){
        System.out.println("学生的信息:");
        System.out.println(super.baseInfo());
        System.out.println("学号:" + stu_id);
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                '}' + super.toString();
    }
}
