package com.zledu.homeworks_;

public class Homeworks05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}
class A{
    private final String name = "AAA";
    public void f1(){
        //局部内部类
        class B{
            private String name = "BBB";
            public void show(){
                System.out.println("name=" + name + " A类中的name=" + A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}