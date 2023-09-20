package com.zledu.extend_.improve_;

public class Base { //父类
    public int n1 = 100;
    protected  int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base(){ //无参构造器
        System.out.println("父类Base()构造器被调用...");
    }
    public Base(String name, int age){ //有参构造器
        System.out.println("父类Base(String name, int age)构造器被调用...");
    }
    public Base(String name){ //有参构造器
        System.out.println("父类Base(String name)构造器被调用...");
    }

    public int getN4(){
        return n4;
    }
    public void test100(){
        System.out.println("test100");
    }
    protected void test200(){
        System.out.println("test200");
    }
    void test300(){
        System.out.println("test300");
    }
    private void test400(){
        System.out.println("test400");
    }
    //父类提供的公共方法
    public void callN4(){
        test400();
    }
}
