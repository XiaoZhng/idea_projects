package com.zledu.poly_.dynamic_;


//动态绑定机制
//1.当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
//2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
public class DynamicBingding {
    public static void main(String[] args) {
         A a = new B(); //向上转型
        System.out.println(a.sum()); //40 20+10=30
        System.out.println(a.sum1()); //30 10+10=20
    }
}

class A{ //父类
    public int i = 10;

    public int sum(){
        return getI() + 10;
    }
    public int sum1(){
        return i + 10;
    }
    public int getI(){
        return i;
    }
}
class B extends A{ //子类
    public int i = 20;

//    public int sum(){
//        return getI() + 20;
//    }
//    public int sum1(){
//        return i + 10;
//    }
    public int getI(){
        return i;
    }
}