package com.zledu.generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class CustomMethodGeneric {
    public static void main(String[] args) {

        //泛型方法的使用
        Car car = new Car();
        //当调用方法时，传入参数，编译器，就会确定类型
        car.fly("jack", 10);//String, Integer

        //T -> Double  R -> String
        fish<Double, String> fish = new fish<>();
        fish.eat("tom", 10.1f);//String, Float
        fish.ok(99.99, new ArrayList());//Double, ArrayList
    }
}
//泛型方法，可以定义在普通类中，也可以定义在泛型类中
class Car{//普通类

    public void run(){}//普通方法

    //1. <T, R> 就是泛型
    //2. 是提供给fly使用的
    public<T, R> void fly(T t, R r){ //泛型方法
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}
class fish<T, R>{ //泛型类

    public void run(){}//普通方法

    public<U, M> void eat(U u, M m){ // 泛型方法
        System.out.println(u.getClass());
        System.out.println(m.getClass());
    }

    //1. 下面的hi方法不是泛型方法
    //2. 是hi方法使用类声明的 泛型
    public void hi(T t){}
    //泛型方法可以使用类声明的 泛型，也可以使用自己声明的 泛型
    public<K> void ok(T t, K k){
        System.out.println(t.getClass());
        System.out.println(k.getClass());
    }
}