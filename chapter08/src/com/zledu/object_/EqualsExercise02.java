package com.zledu.object_;

//import com.sun.org.apache.xpath.internal.operations.String;

public class EqualsExercise02 {
    public static void main(String[] args) {
        Person_ p1 = new Person_();
        p1.name = "hello";

        Person_ p2 = new Person_();
        p2.name = "hello";

        System.out.println(p1 == p2);//false
        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.equals(p2));//false

        String s1 = new String("word");//true
        String s2 = new String("word");//false
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }
}

class Person_{
    public String name;
}