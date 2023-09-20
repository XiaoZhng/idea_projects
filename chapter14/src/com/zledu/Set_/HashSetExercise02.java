package com.zledu.Set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Person("jack", 5000.0, new MyDate(2000, 1,11)));
        hashSet.add(new Person("tom", 60000.0, new MyDate(2001, 2,21)));
        hashSet.add(new Person("jack", 5000.0, new MyDate(2000, 1,11)));
        System.out.println("hashset=" + hashSet);

        MyDate myDate1 = new MyDate(1, 2, 3);
        MyDate myDate2 = new MyDate(1, 2, 3);
        System.out.println("hash=" + myDate1.hashCode());
        System.out.println("hash=" + myDate2.hashCode());

        /**
         * 要求：当 name 和 birthday相同时，就不能添加到HashSet中
         * (1) add()底层是先判断 hash值是否相同，相同则添加失败，否则添加成功，所以要先考虑 hashCode值
         * (2) 如果只重写了 Person类的hashCode(),只能判定 name 的hashCode值相同，而不能判定 birthday的也相同
         *       因为 birthday的运行类型是 MyDate类
         * (3) 只有重写 MyDate类的 hashCode()，才能使得创建 两个相同的MyDate类的对象实例的hashCode值相同
         * (4) 才能在 Person类中，重写的hashCode()，获取的 两个相同的birthday属性，返回的hashCode相同
         */
    }
}

class Person{
    private String name;
    private double sal;
    private MyDate birthday;

    public Person(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name='" + name + ", sal=" + sal +
                ", birthday=" + birthday;
    }
    //当 name 和 birthday 的值相同时，就返回的hash值相同
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    @Override
    public String toString() {
        return year + "," +month + ", " + day;
    }

    //重写hashCode()，使得两个 MyDate对象的hashCode值相同
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}