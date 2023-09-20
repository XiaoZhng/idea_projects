package com.zledu.abstract_;

public class AbstractDetail02 {
    public static void main(String[] args) {
        System.out.println("hi");
    }
}
//抽象方法不能使用private、final和 static来修饰，因为这些关键字都是和重写相违背的
abstract class H{
//    public static abstract void hi();
}

//如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类
abstract class E{
    public abstract void hi();
}

abstract class F extends E{
    @Override
    public void hi() { //这里相当于G子类实现了父类E的抽象方法，所谓实现方法，就是有方法体

    }
}

//抽象类的本质还是类，所以可以有类的各种方法
abstract class D{
    public String name = "hellw";
    public int age = 10;
    public void hi(){
        System.out.println("hi");
    }
}