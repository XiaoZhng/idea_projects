package com.zledu.abstract_.exercise_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 1, 10000, 20000);
        CommonEmployee tom = new CommonEmployee("tom", 2, 8000);
        jack.work();
        tom.work();
    }
}
