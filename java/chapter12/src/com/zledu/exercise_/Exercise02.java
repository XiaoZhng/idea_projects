package com.zledu.exercise_;

public class Exercise02 {
    public static void main(String[] args) /*throws AgeExercise*/ {

        int age = 1;
        if (!(age > 0 && age < 20)) {
            throw new AgeExercise("年龄范围不正确...");//不符合条件就抛出自定义异常
        }
        System.out.println("年龄范围正确...");
    }
}

//定义自定义异常
//通常情况下继承 RuntimeException
//把自定义异常做成 运行时异常，好处是有默认处理机制
class AgeExercise extends RuntimeException {
    public AgeExercise(String message) {
        super(message);
    }
}