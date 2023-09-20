package com.zledu.main_;

public class main01 {
    // 静态变量/属性
    private static String name = "jack";

    // 非静态的变量/属性
    private int n1 = 100;

    //非静态方法
    public void say(){
        System.out.println("main01类中的 say()");
    }

    //静态方法
    public static void look(){
        System.out.println("main01类中的 look()");
    }
    public static void main(String[] args) {

        //可以直接使用name
        //1.静态方法可以访问本类的静态成员
        System.out.println(name);
        look();
        //2.静态方法main，不可以访问本类的非静态成员
        //3.静态方法main，要访问本类的非静态成员，需要先创建对象，再调用即可
        main01 main01 = new main01();
        System.out.println(main01.n1);
        main01.say();
    }
}
