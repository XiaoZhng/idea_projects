package com.zledu.enum_.exercise_;

public class Exercise05 {
    public static void main(String[] args) {
        music m1 = music.m1;
        m1.f1();
    }
}
class A{}
//错误写法
//因为使用了enum关键字后就不能继承其他类了，enum会隐式继承Enum，而java是单继承机制
//enum car extends A{}
interface play{
    void f1();
}
enum music implements play{
    m1();

    music() {
    }

    @Override
    public void f1() {
        System.out.println("播放音乐...");
    }
}