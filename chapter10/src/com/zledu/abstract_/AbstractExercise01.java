package com.zledu.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 001, 20000);
        jack.setBonus(5000);
        jack.work();

        CommonEmployee tom = new CommonEmployee("tom", 002, 10000);
        tom.work();
    }
}