package com.zledu.codeblock;

public class codeBlockDetail04 {
    public static void main(String[] args) {
        //(1) 先进行类加载
        //(1.1) 先加载 父类A02 再加载 子类B02
        //(2) 再创建对象
        //(2.2)
        new B02();//对象
    }
}

class A02{
    private static int n1 = get01();
    static {
        System.out.println("A02静态代码块");//2
    }
    {
        System.out.println("A02普通代码块");//5
    }
    public int n3 = get02();
    public static int get01(){
        System.out.println("get01");//1
        return 10;
    }
    public static int get02(){
        System.out.println("get02");//6
        return 10;
    }

    public A02() {
        //super();
        //普通代码块和普通属性初始化
        System.out.println("A02构造器");//7
    }
}
class B02 extends A02{
    private static int n3 = get03();
    static {
        System.out.println("B02静态代码块");//4
    }
    public int n5 = get04();
    {
        System.out.println("B02普通代码块");//9
    }
    public static int get03(){
        System.out.println("get03");//3
        return 10;
    }
    public static int get04(){
        System.out.println("get04");//8
        return 10;
    }
    public B02() {
        //super();
        //普通代码块和普通属性初始化
        System.out.println("B02构造器");//10
    }
}
class C02{
    private static int n1 = 10;
    private int n2 = 20;

    private static void m1(){

    }
    private void m2(){

    }
    static {
        //静态代码块只能调用静态成员
        System.out.println(n1);//0k
        //System.out.println(n2);//错误
        m1();
        //m2();//错误
    }
    {
        //普通代码块，可以调用任意成员
        System.out.println(n1);//0k
        System.out.println(n2);
        m1();
        m2();
    }
}