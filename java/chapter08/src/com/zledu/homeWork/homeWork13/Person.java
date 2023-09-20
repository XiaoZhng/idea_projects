package com.zledu.homeWork.homeWork13;

public class Person {
    //共有属性
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //玩的方法
    public String play(){
        return name + "爱玩";
    }
    //分析得出需要有个信息输出发方法
    public String baseInfo(){
        return "姓名：" + name + "\n年龄：" + age + "\n性别:" + sex;
    }
    //重写toString

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
