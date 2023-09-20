package com.boot.controller.utils;

/**
 * @author Alonso
 */
public class test {

}
class C {
    C() {
        System.out.print("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }
}

class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new Test();
    }
}