package com.zledu.exercise_;

public class Exercise01 {
    public static void main(String[] args) {
        Test test = new Test("111");
    }
}
class Sample{
    Sample(String s){
        System.out.println(s);
    }
    Sample(){
        System.out.println("Sample默认构造器调用");//3
    }
}
class Test{
    Sample sam1 = new Sample();
    static Sample sam = new Sample("sam静态成员初始化");//1
    static {
        System.out.println("static块执行");//2
        if (sam == null) System.out.println("sam is null");
    }
    Test(String s){
        System.out.println(s);//4
    }
    Test(){
        System.out.println("Test默认构造器调用");//
    }
}