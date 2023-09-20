package com.zledu.extend_;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小明";
        pupil.testing();
        pupil.age = 18;
        pupil.setScore(90);
        pupil.showInfo();

        System.out.println("-----------------");
        Graduate graduate = new Graduate();
        graduate.name = "小刚";
        graduate.testing();
        graduate.age = 20;
        graduate.setScore(100);
        graduate.showInfo();
    }
}
