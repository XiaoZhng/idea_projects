package com.zledu.generic.customgeneric;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}
/*
    泛型接口使用说明
    1. 接口中，静态成员也不能使用泛型
    2. 泛型接口的类型，在继承接口或者实现接口时确定
    3. 没有指定泛型，默认为Object
 */

interface IA extends IUsb<String, Double> {

}

//当我们去实现 IA 接口时，因为 IA 在继承 IUsb 接口时，指定了 U=String，R=Double
//在实现 IUsb 接口的方法时，使用String替换U，Double替换R
class AA implements IA {
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}

//实现接口时，直接指定泛型接口的类型
//给 U指定Integer，给 R指定Float
//所以，当我们实现IUsb接口时，会使用 Integer替换U，Float替换R
class BB implements IUsb<Integer, Float> {

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}

//没有指定泛型，默认为Object
//建议直接写成 IUsb<Object, Object>
class CC implements IUsb { //等价于 class CC implements IUsb<Object, Object>{}
    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }

}

interface IUsb<U, R> {

    //普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk8中，可以在接口中，使用默认方法，也可以使用泛型
    default R method(U u) {
        return null;
    }
}