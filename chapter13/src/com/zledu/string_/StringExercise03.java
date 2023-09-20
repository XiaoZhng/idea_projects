package com.zledu.string_;

public class StringExercise03 {
    public static void main(String[] args) {
        //(1)
        String a = "jack";//指向常量池的jack
        String b = new String("jack");//指向堆中的value,然后查看常量池是否有jack，如果有就指向，如果没有则创建再指向
        System.out.println(a.equals(b));//String中的equals重写了，所以判断值是否相等 true
        System.out.println(a == b);//引用数据类型判断对象是否相等 false
        //b.intern() 方法返回常量池地址
        System.out.println(a == b.intern());//a是指向常量池，b.intern()是返回常量池地址 true
        System.out.println(b == b.intern());//b指向堆中的value对象，b.intern()是返回常量池地址 false
        System.out.println("------------------------");
        //(2) false true true false
        String s1 = "jack";//指向常量池的jack
        String s2 = "java";//指向常量池的java
        String s4 = "java";//指向常量池的java
        String s3 = new String("java");//指向堆中的value再指向常量池的java
        System.out.println(s2 == s3);//f
        System.out.println(s2 == s4);//t
        System.out.println(s2.equals(s3));//t
        System.out.println(s1 == s2);//f
        System.out.println("------------------------");
        //(3) t t t f
        Person p1 = new Person();
        p1.name = "jack";
        Person p2 = new Person();
        p2.name = "jack";

        System.out.println(p1.name.equals(p2.name));//t 比较内容
        System.out.println("============" + p1.equals(p2));//f
        System.out.println(p1.name == p2.name);//t
        System.out.println(p1.name == "jack");//t

        String str1 = new String("asd");
        String str2 = new String("asd");
        System.out.println(str1 == str2);//f
    }
}
class Person{
    public String name;
}