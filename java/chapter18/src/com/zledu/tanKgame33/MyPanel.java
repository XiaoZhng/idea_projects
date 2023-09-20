package com.zledu.tanKgame33;

//坦克大战的绘图区域

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable{

    //定义自己的坦克
    MyTank myTank = null;

    //定义敌人的坦克，因为敌人的坦克数量多，所以要用到集合 Vector，考虑到多线程问题
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;//定义坦克数量

    //定义一个炸弹集合 Vector，存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，初始化
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(){
        myTank = new MyTank(500, 100);//初始化自己的坦克
        //初始化敌人的坦克
        //在初始化坦克的时候，定义坦克的方向
        for (int i = 0; i < enemyTankSize; i++) {
            //因为构造器无法定义方向，所以把构造器单独设成对象，
            //然后用 enemyTank调用set设置方向，再把enemyTank对象，添加到集合中
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
            //在创建敌人坦克时，初始化一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            //把初始化的子弹，放入敌人坦克子弹的集合中
            enemyTank.getShots().add(shot);
            //在初始化敌人坦克时，就启动敌人坦克线程，让坦克动起来
            new Thread(enemyTank).start();
            //启动shot线程
            new Thread(shot).start();
        }

        //炸弹图片初始化
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img1.jpg"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img2.jpg"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img3.jpg"));

        //问题：第一次击中敌方坦克不出现爆炸现象
        //原因：当第一次击中敌方坦克时，才创建炸弹对象放入集合，所以第一次不出现
        //在初始化时，先创建一个炸弹对象，放入集合中
        Bomb bomb = new Bomb(10, 10);
        bombs.add(bomb);
    }
    //编写方法，判断子弹是否击中坦克
    public void hitTanK(Tank tank, Shot shot){
        //通过坦克的方向来判断是否击中
        //击中就把子弹、坦克的存活率设为false，从敌方坦克集合中移除
        switch (tank.getDirection()){
            case 0://上
            case 2://下
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40 && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60){
                    shot.setLive(false);
                    tank.setLive(false);
                    enemyTanks.remove(tank);

                    //击中坦克时，就创建一个炸弹对象
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    //把炸弹对象放入集合中
                    bombs.add(bomb);
                }
                break;
            case 1://右
            case 3://左
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60 && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40){
                    shot.setLive(false);
                    tank.setLive(false);
                    enemyTanks.remove(tank);

                    //击中坦克时，就创建一个炸弹对象
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    //把炸弹对象放入集合中
                    bombs.add(bomb);
                }
                break;
        }
    }

    //我方坦克子弹是否击中敌方方坦克
    public void hitEnemyTanK(){
        //判断我方子弹存活，并且不为空
        if (myTank.getShot() != null && myTank.getShot().getLive()){
            //取出敌方坦克
            for (int i = 0; i < enemyTanks.size(); i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                //如果敌方坦克存活
                if (enemyTank.getLive()){
                    hitTanK(enemyTank, myTank.getShot());
                }
            }
        }
    }

    //判断敌方坦克是否击中我方坦克
    public void hitMyTanK(){
        for (int i = 0; i < enemyTanks.size(); i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历敌方坦克子弹
            for (int j = 0; j < enemyTank.getShots().size(); j++){
                Shot shot = enemyTank.getShots().get(j);
                //如果我方坦克存活，并且敌方子弹也存活，就调用 hitTanK()
                if (myTank.getLive() && shot.getLive()){
                    hitTanK(myTank, shot);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//画一个矩形边框，为绘图区域，默认黑色

        //画自己的坦克方法
        //加个判断，我方坦克存活，就画
        if (myTank.getLive() /*&& myTank != null*/) {
            drawTank(myTank.getX(), myTank.getY(), 0, myTank.getDirection(), g);
        }

        //画出敌人的坦克，遍历集合得到所有的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);//获取到集合中的一个个坦克
            if (enemyTank.getLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), 1, enemyTank.getDirection(), g);
                //遍历敌人坦克子弹集合，取出子弹，判断子弹是否存活，存活就绘制，否则移除
                for (int j = 0; j < enemyTank.getShots().size(); j++) {
                    Shot shot = enemyTank.getShots().get(j);
                    if (shot.getLive()) {
                        g.fill3DRect(shot.getX(), shot.getY(), 2, 2, false);
                    } else {
                        enemyTank.getShots().remove(shot);
                    }
                }
            }
        }

        //画子弹
        //如果子弹不为null 并且 子弹存活率为true，就画出子弹
        //加个判断，我方坦克销毁了，子弹也销毁
        if (myTank.getShot() != null && myTank.getShot().getLive() && myTank.getLive()){
            g.fill3DRect(myTank.getShot().getX(), myTank.getShot().getY(), 2, 2, false);
        }

        //画出炸弹
        //遍历炸弹集合，用炸弹生命周期来判断画哪张
        for (int i = 0; i < bombs.size(); i++){
            Bomb bomb = bombs.get(i);
            if (bomb.getLife() > 6){
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            }else if (bomb.getLife() > 3){
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            }else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            //调用bomb类中的life方法，让生命周期--，达到效果
            bomb.life();
            //如果bomb生命周期为0，就把炸弹从集合中移除
            if (bomb.getLife() == 0){
                bombs.remove(bomb);
            }
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
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            myTank.setDirection(1);
            if (myTank.getX() + 60 < 1000) {
                myTank.moveRight();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            myTank.setDirection(2);
            if (myTank.getY() + 60 < 750) {
                myTank.moveDown();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            myTank.setDirection(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }
        }

        //监听用户按下J键，就发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J){
            //如果子弹消亡了，才能能再发射子弹
            if (myTank.getShot() == null || !myTank.getShot().getLive()) {
                myTank.ShotFire();
            }
        }
        //让面板重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //因为画子弹要不停重绘，所以把 MyPanel设置为线程
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //调用 hitEnemyTanK,我方坦克击中敌方坦克
            hitEnemyTanK();
//            if (myTank.getShot() != null && myTank.getShot().getLive()){
//                for (int i = 0; i < enemyTanks.size(); i++){
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTanK(enemyTank, myTank.getShot());
//                }
//            }
            //调用 hitMyTanK,敌方击中我方坦克
            hitMyTanK();
            //每隔100毫秒，重绘
            repaint();
        }
    }
}
