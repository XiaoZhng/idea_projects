package com.zledu.Set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("jack", 10));
        hashSet.add(new Employee("tom", 20));
        hashSet.add(new Employee("jack", 10));
        System.out.println(hashSet);
    }
}
@SuppressWarnings({"all"})
class Employee{
   private String name;
   private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //如果 name 和 age 的值相同，则返回相同的hash值
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}