package com.zledu.poly_.objectpoly_;

public class PolyObject {
    public static void main(String[] args) {
        //体验对象多态特点
        //animal 编译类型就是 Animal，运行类型 Dog
        Animal animal = new Dog();
        //因为运行时，执行到该行时，animal运行类型是Dog，所以say就是Dog的say
        animal.say(); //Dog say() 狗再叫

        //animal 编译类型 Animal，运行类型就是 Cat
        animal = new Cat();
        animal.say(); //Cat say() 猫在叫
    }
}
