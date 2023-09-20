package com.zledu.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }
    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(500, 500);
        //窗口JFrame对象 可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//KeyListener 是监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球移动，把左上角坐标(x,y)设置成变量
    int x = 10;//起始点的x坐标
    int y = 10;//起始点的y坐标
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符串输入时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下时，该方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {

        //System.out.println((char)e.getKeyCode() + "被按下...");

        //根据用户按下的不同键，来处理小球的移动
        //在java中，会给每个键，分配一个值(int)
        if (e.getKeyCode() == KeyEvent.VK_W){ //KeyEvent.VK_W 就是键盘按下W对应的Code值
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            y++;
        }else if (e.getKeyCode() == KeyEvent.VK_A){
            x--;
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            x++;
        }
        //让画板重绘
        this.repaint();
    }

    //当某个键释放(松开)时，该方法就会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}