package com.zledu.homework;

public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}

class A{
    //私有常量name
    private String name = "jack";

    public void hi(){
        //定义局部内部类B
        class B{
            private String name = "tom";//私有常量name

            public void show(){
                System.out.println("局部内部类的ame= " + name + " 外部类的name= " + A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}