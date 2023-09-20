package com.zledu.homeWork;

public class LabeledPoint extends Point{
    //特有属性
    private String name;
    //方法
    public LabeledPoint(String name, double x, double y) {
        super(x, y);
        this.name = name;
    }
}
