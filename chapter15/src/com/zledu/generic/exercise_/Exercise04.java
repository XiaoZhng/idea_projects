package com.zledu.generic.exercise_;

public class Exercise04 {
    public static void main(String[] args) {

    }
}

//自定义泛型方法
class Fish<T, R>{
    T name;
    R age;

    public Fish(T name, R age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println(name.getClass());
        System.out.println(age.getClass());
    }
}

//没有指定泛型，默认为Object
//最好写成 class Pig implements IAA<Object, Object>{}
class Pig implements IAA /*<Object, Object>*/{

    @Override
    public void hi(Object o, Object o2) {

    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void run(Object a1, Object a2, Object b1, Object b2) {

    }
}
//泛型的接口类型，在继承接口和实现接口的时候确定
//实现接口
class Dogs implements IB{

    @Override
    public void hi(String s, Integer integer) {

    }

    @Override
    public String get(String s) {
        return null;
    }

    @Override
    public void run(String a1, String a2, Integer b1, Integer b2) {

    }
}

//继承接口
interface IB extends IAA<String, Integer>{

}

//自定义泛型接口
interface IAA<A, B>{
    //普通方法可以使用接口泛型
    void hi(A a, B b);
    A get(A a);
    void run(A a1, A a2, B b1, B b2);

}

//自定义泛型
class Cats<T, R>{
    T t;
    R r;
    //静态方法不能使用泛型
    //public static void hi(T t){}

    public Cats(T t, R r) {
        this.t = t;
        this.r = r;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }
}