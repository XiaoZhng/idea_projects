package com.zledu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(new Dog("jack", 10));
        list.add(new Dog("king", 11));
        list.add(new Dog("tom", 12));

        //用迭代器和增强for两种方式来遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Dog= " + iterator.next());
        }

        System.out.println("------------------");

        for (Object i : list) {
            System.out.println("i= " + i);
        }
    }
}

class Dog {
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}