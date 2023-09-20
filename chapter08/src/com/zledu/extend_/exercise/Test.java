package com.zledu.extend_.exercise;

//编写Test类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性赋值
//以及从Computer类继承的属性赋值，并使用方法并打印输出信息
public class Test {
    public static void main(String[] args) {
        PC pc = new PC("intel",16,500,"Mi");
        NotePad notePad = new NotePad("AMD",16,500,"white");
        pc.info();
        notePad.color();
    }
}
