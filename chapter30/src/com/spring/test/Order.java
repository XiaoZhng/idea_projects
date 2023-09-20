package com.spring.test;

/**
 * @author Alonso
 */
public class Order {
    private String name;
    private int age;
    public Order(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void orderTest(){
        System.out.println(name + ":" + age);
    }
}
