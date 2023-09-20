package com.zledu.exception_;

//类型转换异常
public class ClassCastException {
    public static void main(String[] args) {
        A b = new B();//向上转型
        B b2 = (B)b;//向下转型
        C b3 = (C)b;//ClassCastException 类型转换异常
    }
}

class A{}
class B extends A{}
class C extends A{}