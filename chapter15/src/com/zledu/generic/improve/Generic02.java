package com.zledu.generic.improve;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Generic02 {
    public static void main(String[] args) {

        //使用传统方法 -> 使用泛型
        //1.当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是Dog类型
        //2.如果编译器发现添加的类型，不满足要求，就会报错
        //3.在遍历时，可以直接取出 Dog 类型而不是 Object
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("jack", 10));
        arrayList.add(new Dog("tom", 1));
        arrayList.add(new Dog("lucy", 8));

        //加入不小心添加了一只猫
        //存在隐患，编译器发现不了
        //arrayList.add(new Cat("tim", 5)); //ClassCastException

        for (Dog dog :arrayList) {
            System.out.println(dog.getName() + "," + dog.getAge());
        }


    }
}
/*
    编写程序，在ArrayList 中，台南佳三个Dog对象
    Dog对象有name,age 并输出name和age
    引入泛型
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