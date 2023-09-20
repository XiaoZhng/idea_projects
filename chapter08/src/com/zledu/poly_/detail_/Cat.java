package com.zledu.poly_.detail_;

public class Cat extends Animal{
    public void eat(){ //方法重写
        System.out.println("猫吃鱼");
    }
    public void catchMouse(){ //cat特有的方法
        System.out.println("猫捉老鼠");
    }
}
