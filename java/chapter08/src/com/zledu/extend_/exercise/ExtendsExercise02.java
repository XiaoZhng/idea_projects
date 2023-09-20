package com.zledu.extend_.exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        C c = new C();
    }
}
class A{
    public A(){
        System.out.println("我是A类");
    }
}
class B extends A{ //B类继承A类
    public B(){
        System.out.println("我是B类的无参构造器");
    }
    public B(String name){
        System.out.println(name + "我是B类的有参构造器");
    }
}
class C extends B{
    public C(){
        this("hello");
        System.out.println("我是C类的无参构造");
    }
    public C(String name){
        super("hahah");
        System.out.println("我是C类的有参构造器");
    }
}