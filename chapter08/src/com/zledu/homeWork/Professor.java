package com.zledu.homeWork;

public class Professor extends Teacher{

    public Professor(String name, int age, String post, double salary, double great) {
        super(name, age, post, salary, great);
    }

    @Override
    public String introduce() {
        System.out.println("这是教授的信息");
        return super.introduce();
    }
}
