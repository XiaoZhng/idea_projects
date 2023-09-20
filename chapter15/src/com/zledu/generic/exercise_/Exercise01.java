package com.zledu.generic.exercise_;

public class Exercise01 {
    public static void main(String[] args) {

        //注意：E具体的数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型
        Person<String> jack = new Person<>("jack");
        jack.show();//String

        //泛型的类型不能是基本数据类型，只能是引用数据类型
        //new Person<int>()
        Person<Integer> person1 = new Person<>(100);
        person1.show();//Integer

    }
}

class Person<E> {
    E name;
    public Person(E name){
        this.name = name;
    }
    public void show(){
        System.out.println(name.getClass());
    }
}