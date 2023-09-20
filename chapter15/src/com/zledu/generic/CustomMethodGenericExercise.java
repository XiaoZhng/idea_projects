package com.zledu.generic;

public class CustomMethodGenericExercise {
    public static void main(String[] args) {

        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);//Integer     10 会自动装箱 Integer
        apple.fly(new cat());//cat
    }
}
class Apple<T, R, M>{ //自定义泛型类
    public<E> void fly(E e){
        System.out.println(e.getClass().getSimpleName());
    }
    //public void eat(U u){}//错误的，U没有定义，既不是泛型方法，也没有使用类实现的泛型
    public void run(M m){}//ok
}
class cat{}