package com.zledu.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{//JFrame对应窗口，可以理解成是一个画框

    //先定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {

        //演示如何在画板上画出圆形
        new DrawCircle();
        System.out.println("退出程序...");
    }
    //构造器
    public DrawCircle(){
        //初始化面板
        mp = new MyPanel();
        //把面板放入窗口(画框)中
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 300);
        //当点击窗口的小×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可视化，可以显示
    }
}

//先定义一个MyPanel，继承JPanel，画图形，就在面板上画
class MyPanel extends JPanel {

    //说明：
    //1. MyPanel 对象就是一个面板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {//绘图的方法
        super.paint(g);//调用父类的方法，完成初始化，保留

        g.drawOval(10, 10, 100, 100);
    }
}