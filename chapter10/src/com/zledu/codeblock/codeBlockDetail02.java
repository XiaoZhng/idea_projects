package com.zledu.codeblock;

public class codeBlockDetail02 {
    public static void main(String[] args) {

        //输出循序:(1) 静态方法 getN1 调用 (2) A() 静态代码块调用...
        //A a1 = new A();
// 输出顺序：(1) A() 静态代码块调用... (2) 静态方法 getN1 调用 (3) 普通方法 getN2 调用 (4) A() 普通代码块调用...
        //A a2 = new A();
//输出顺序：(1)A() 静态代码块调用...(2)静态方法 getN1 调用(3)普通方法 getN2 调用(4) A() 普通代码块调用...(5)A() 构造器调用...
        A a3 = new A();
    }
}

class A{

    //普通属性初始化
    private int n2 = getN2();

    static { //静态代码块
        System.out.println("A() 静态代码块调用...");
    }

    //静态属性的初始化
    private static int n1 = getN1();

    { //普通代码块
        System.out.println("A() 普通代码块调用...");
    }

    //静态方法
    public static int getN1(){
        System.out.println("静态方法 getN1 调用");
        return 100;
    }

    // 普通方法/非静态方法
    public static int getN2(){
        System.out.println("普通方法 getN2 调用");
        return 200;
    }

    //无参构造器
    public A(){
        System.out.println("A() 构造器调用...");

    }
}