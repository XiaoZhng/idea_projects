package com.zledu.generic.customgeneric;

public class CustomGeneric {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

    }
}
/*
    1.Tiger 后面的泛型，所以我们把 Tiger 就称为自定义泛型类
    2.T, R, N 是泛型的标识符，一般是单个大写字母
    3.泛型标识符可以有多个
    4.普通成员可以使用泛型(属性、方法)
    5.使用泛型的数组，不能初始化
    6.静态方法中不能使用类的泛型

 */
class Tiger<T, R, N>{
    String name;
    T t; //属性使用泛型
    R r;
    N n;
    //因为数组在new的时候不能确定T的类型，就无法在内存开空间
    T[] ts;

    public Tiger(String name, T t, R r, N n) { //构造器使用泛型
        this.name = name;
        this.t = t;
        this.r = r;
        this.n = n;
    }

    //因为静态方法是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化
    //static R r2;
//    public static R r3(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() { //返回类型使用泛型
        return t;
    }

    public void setT(T t) { //方法使用泛型
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public N getN() {
        return n;
    }

    public void setN(N n) {
        this.n = n;
    }

    public T[] getTs() {
        return ts;
    }

    public void setTs(T[] ts) {
        this.ts = ts;
    }
}