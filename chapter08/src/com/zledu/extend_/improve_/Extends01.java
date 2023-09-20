package com.zledu.extend_.improve_;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小米";
        pupil.age = 18;
        pupil.testing();
        pupil.setScore(80);
        pupil.showInfo();

        System.out.println("--------------");
        Graduate graduate = new Graduate();
        graduate.name = "小明";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(90);
        graduate.showInfo();
    }
}
