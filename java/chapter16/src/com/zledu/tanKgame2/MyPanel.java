package com.zledu.tanKgame2;

//坦克大战的绘图区域

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {

    //定义自己的坦克
    MyTank myTank = null;

    //定义敌人的坦克，因为敌人的坦克数量多，所以要用到集合 Vector，考虑到多线程问题
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;//定义坦克数量

    public MyPanel(){
        myTank = new MyTank(100, 100);//初始化自己的坦克
        //初始化敌人的坦克
        //在初始化坦克的时候，定义坦克的方向
        for (int i = 0; i < enemyTankSize; i++) {
            //因为构造器无法定义方向，所以把构造器单独设成对象，
            //然后用 enemyTank调用set设置方向，再把enemyTank对象，添加到集合中
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//画一个矩形边框，为绘图区域，默认黑色

        //画自己的坦克方法
        drawTank(myTank.getX(), myTank.getY(), 0, myTank.getDirection(), g);

        //画出敌人的坦克，遍历集合得到所有的坦克
        for (int i = 0; i < enemyTanks.size(); i++){
            EnemyTank enemyTank = enemyTanks.get(i);//获取到集合中的一个个坦克
            drawTank(enemyTank.getX(), enemyTank.getY(), 1, enemyTank.getDirection(), g);
        }

    }

    //把画坦克封装成一个方法
    /**
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

        //根据坦克方向，来绘制对应形状坦克
        //direction 表示方向(0：向上 1：向右 2：向下 3：向左)
        //判断坦克的方向
        switch (direction){
            case 0: //头部朝上
                g.fill3DRect(x, y, 10, 60, false);//坦克的左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克的右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克的中间矩形
                g.fillOval(x + 10, y + 20, 20, 20);//坦克的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);//坦克的炮管
                break;
            case 1: //头部朝右
                g.fill3DRect(x, y, 60, 10, false);//坦克的上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克的下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克的中间矩形
                g.fillOval(x + 20, y + 10, 20, 20);//坦克的圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//坦克的炮管
                break;
            case 2: //头部朝下
                g.fill3DRect(x, y, 10, 60, false);//坦克的左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克的右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克的中间矩形
                g.fillOval(x + 10, y + 20, 20, 20);//坦克的圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//坦克的炮管
                break;
            case 3: //头部向左
                g.fill3DRect(x, y, 60, 10, false);//坦克的上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克的下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克的中间矩形
                g.fillOval(x + 20, y + 10, 20, 20);//坦克的圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//坦克的炮管
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W){
            //改变坦克的方向
            myTank.setDirection(0);
            myTank.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            myTank.setDirection(1);
            myTank.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            myTank.setDirection(2);
            myTank.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            myTank.setDirection(3);
            myTank.moveLeft();
        }

        //让面板重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
