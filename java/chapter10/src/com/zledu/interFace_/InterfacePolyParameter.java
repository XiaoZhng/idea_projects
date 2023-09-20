package com.zledu.interFace_;

public class InterfacePolyParameter {
    public static void main(String[] args) {

        //接口的多态体现
        //接口类型的变量 if01 可以指向 实现了IF接口的对象实例
        IF if01 = new monster();
        if01 = new car();

        //继承体现多态
        //父类类型的变量 a 可以指向 继承AAA的子类的对象实例
        AAA a = new BBB();//向上转型 父类的引用指向子类的对象
        a = new CCC();

    }
}

interface IF{}
class monster implements IF{}
class car implements IF{}

class AAA{}
class BBB extends AAA{}
class CCC extends AAA{}