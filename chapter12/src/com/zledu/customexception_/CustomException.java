package com.zledu.customexception_;

public class CustomException {
    public static void main(String[] args) {
        int age = 18;
        //要求范围在18-120之间，否则抛出一个自定义异常
        if (!(age >= 18 && age <= 120)){
            //这里可以通过构造器设置信息
            throw new AgeException("要求范围在18-120之间");
        }
        System.out.println("年龄范围正确");
    }
}

//自定义异常
//1.一般情况下，自定义异常是继承 RuntimeException(运行异常)
//2,即把自定义异常 做成运行时异常，好处是，可以使用默认处理机制
//3.即比较方便
class AgeException extends RuntimeException{
    public AgeException(String message) {//构造器
        super(message);
    }
}