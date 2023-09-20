package com.zledu.homeWork;

public class Teacher {
    //(1) 要求有属性 "姓名name","年龄age","职称post","基本工资salary"
    private String name;
    private int age;
    private String post;
    private double salary;
    //(3) 编写教师类的三个子类：教授类(Professor),副教授类,讲师类,工资类别分别为：教授为1.3、副教授为1.2
    //讲师为1.1 在三个子类里面都重写父类的introduce()方法
    private double great;

    public Teacher(String name, int age, String post, double salary, double great) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.great = great;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGreat() {
        return great;
    }

    public void setGreat(double great) {
        this.salary = great;
    }
    //(2) 编写业务方法，introduce(),实现输出一个教师的信息
    public String introduce(){
        return "姓名：" + getName() + " 年龄：" + getAge() + " 职称：" + getPost() + " 基本工资：" + getSalary() + " 工资类别：" + getGreat();
    }
}
