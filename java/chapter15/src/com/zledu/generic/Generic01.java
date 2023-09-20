package com.zledu.generic;

import java.util.ArrayList;

public class Generic01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //使用传统方法
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("jack", 10));
        arrayList.add(new Dog("tom", 1));
        arrayList.add(new Dog("lucy", 8));

        //加入不小心添加了一只猫
        //存在隐患，编译器发现不了
        arrayList.add(new Cat("tim", 5)); //ClassCastException

        for (Object o :arrayList) {
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + "," + dog.getAge());
        }

    }
}
/*
    编写程序，在ArrayList 中，台南佳三个Dog对象
    Dog对象有name,age 并输出name和age
 */
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
}
class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
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
}