package com.zledu.pkg;

import com.zledu.modifier.A;

public class Test {
    public static void main(String[] args) {
        //不同包
        //在不同包下，可以访问public 修饰的属性或方法
        //但是不能访问 protected，默认，private修饰的属性或方法
        A a = new A();
        System.out.println("n1=" + a.n1 );

        a.m1();
        //不能访问a.m2();a.m3();a.m4();
    }
}
