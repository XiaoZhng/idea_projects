package com.zledu.string_.exercise_;

public class Exercise01 {
    public static void main(String[] args) {

        //装箱：基本数据类型 -> 包装类
        //拆箱：包装类 -> 基本数据类型
        //手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        //手动拆箱
        int i = integer.intValue();

        //自动装箱
        int n2 = 200;
        Integer integer2 = n2; //底层用的是 Integer.valueOf(n2);
        //自动拆箱
        int n3 = integer2; //底层用的是 Integer.intValue();
    }
}
