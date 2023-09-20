package com.zledu.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        System.out.println(c1.area());
    }
}

class Circle{
    //要求：赋值的3个位置都写
    private double radius;
    private final double PI = 3.14;
    {//代码块赋值
        //PI = 2;
    }
    //构造器赋值
    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }

    public double area(){
        return PI * (radius * radius);
    }
}