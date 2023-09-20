package com.zledu.extend_.improve_;

public class ExtendsDetail {
    public static void main(String[] args) {
//        System.out.println("===第一个对象===");
//        Sub sub = new Sub(); //调用无参数的构造器

//        System.out.println("===第二个对象===");
//        Sub sub2 = new Sub("jack"); //调用一个参数的构造器

        System.out.println("===第三个对象===");
        Sub sub3 = new Sub("Sam", 10); //调用两个参数的构造器


        //子类继承了所有的属性和方法 (deBug)
        //sub.sayOK();
    }
}
