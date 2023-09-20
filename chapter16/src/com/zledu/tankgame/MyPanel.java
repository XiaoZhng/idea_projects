package com.zledu.tankgame;

//坦克大战的绘图区域

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    //定义自己的坦克
    MyTank myTank = null;

    public MyPanel(){
        MyTank myTank = new MyTank(100, 100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0,                             1000, 750);//画一个矩形边框，为绘图区域，默认黑色

        //画坦克方法
        drawTank(100, 100, 0, 0, g);
        drawTank(200, 100, 1, 0, g);
    }

    //把画坦克封装成一个方法
    /**
     *
     * @param x 坦克的x坐标
     * @param y 坦克的y坐标
     * @param type 坦克的类型(0自己的坦克，1敌人的坦克)
     * @param direction 坦克的方向(0头部朝上，1头部朝下)
     * @param g 画笔
     */
    public void drawTank(int x, int y, int type, int direction, Graphics g){
        //判断坦克的类型
        switch (type){
            case 0: //自己的坦克
                g.setColor(Color.CYAN); //自己坦克的颜色
                break;
            case 1: //敌人的坦克
                g.setColor(Color.orange); //敌人坦克的颜色
                break;
        }

        //判断坦克的方向
        switch (direction){
            case 0: //头部朝上
                g.fill3DRect(x, y, 10, 60, false);//坦克的左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克的右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克的中间矩形
                g.fillOval(x + 10, y + 20, 20, 20);//坦克的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y - 10);
                break;
            case 1: //头部朝下
                break;
        }
    }
}
