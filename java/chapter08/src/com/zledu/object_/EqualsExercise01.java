package com.zledu.object_;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person p1 = new Person("Tim", 10, '男');
        Person p2 = new Person("Tim", 10, '男');

        System.out.println(p1.equals(p2));//false
    }
}

class Person{
    private String name;
    private int age;
    private char gender;

    //判断两个Person对象的内容是否相等
    //如果两个Person对象的各个属性值都一样，则返回true，反之false
    public boolean equals(Object obj){
        //判断如果比较的两个对象是同一个对象，则直接返回true
        if(this == obj){
            return true;
        }
        //类型判断
        if(obj instanceof Person){ //运行类型是Person才比较
            //进行 向下转型 需要obj的各个属性
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        return false;
    }

    public Person(String name, int age, char gender){ //构造器
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}