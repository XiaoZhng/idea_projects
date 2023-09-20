package com.zledu.override_;

//编写一个Person类，包括属性/private(name, age)，构造器，方法say(返回自我介绍的字符串)
public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String say(){
        return "name=" + name + " age=" + age;
    }
}
