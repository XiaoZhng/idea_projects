package com.zledu.tanKgame5;

//坦克大战的绘图区域

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了让Panel 不停的重绘子弹，需要将 MyPanel 实现Runnable，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable{

    //定义自己的坦克
    MyTank myTank = null;

    //定义敌人的坦克，因为敌人的坦克数量多，所以要用到集合 Vector，考虑到多线程问题
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个存放Node对象的Vector，用于恢复敌人坦克坐标方向
    Vector<Node> nodes = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，就加入一个bomb对象到bombs集合中
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 4;//定义坦克数量

    //定义三张炸弹图片，用于存放爆炸效果
    Image image1;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key){
        nodes = Recorder.getNodesEnemyTanK();
        //将 MyPanel对象的 enemyTanKs 设置给 Recorder的 enemyTanks
        Recorder.setEnemyTanks(enemyTanks);
        myTank = new MyTank(500, 100);//初始化自己的坦克

        switch (key){
            case "1":
                //初始化敌人的坦克
                //在初始化坦克的时候，定义坦克的方向
                for (int i = 0; i < enemyTankSize; i++) {
                    //因为构造器无法定义方向，所以把构造器单独设成对象，
                    //然后用 enemyTank调用set设置方向，再把enemyTank对象，添加到集合中
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                    enemyTank.setDirection(2);
                    //调用 EnemyTank类中的 setEnemyTanks()，把 enemyTanks传入
                    enemyTank.setEnemyTanks(enemyTanks);
                    //启动敌人坦克线程
                    new Thread(enemyTank).start();
                    //当每创建一个敌人坦克时，就给该敌人坦克对象初始化一个shot对象，同时启动shot
                    //给enemyTank添加一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
                    //把子弹加入到shots集合中
                    enemyTank.getShots().add(shot);
                    //启动shot对象
                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":
                //初始化敌人的坦克
                //在初始化坦克的时候，定义坦克的方向
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    //因为构造器无法定义方向，所以把构造器单独设成对象，
                    //然后用 enemyTank调用set设置方向，再把enemyTank对象，添加到集合中
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    enemyTank.setDirection(node.getDirection());
                    //调用 EnemyTank类中的 setEnemyTanks()，把 enemyTanks传入
                    enemyTank.setEnemyTanks(enemyTanks);
                    //启动敌人坦克线程
                    new Thread(enemyTank).start();
                    //当每创建一个敌人坦克时，就给该敌人坦克对象初始化一个shot对象，同时启动shot
                    //给enemyTank添加一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
                    //把子弹加入到shots集合中
                    enemyTank.getShots().add(shot);
                    //启动shot对象
                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("输入错误...");
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img1.png"));
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img2.png"));
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img3.png"));
    }

    //编写方法，显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g){

        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("您累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, 0, 0, g);
        g.setColor(Color.BLACK);//这里需要重新设置成黑色，因为画坦克时，颜色已经改变了
        g.drawString(Recorder.getAllEnemyTanKNum() + "", 1080, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//画一个矩形边框，为绘图区域，默认黑色
        showInfo(g);

        //判断坦克的存活率是否为ture
        if (myTank.isLive() && myTank != null) {
            //画自己的坦克方法
            drawTank(myTank.getX(), myTank.getY(), 0, myTank.getDirection(), g);
        }

        //画出敌人的坦克，遍历集合得到所有的坦克
        for (int i = 0; i < enemyTanks.size(); i++){
            EnemyTank enemyTank = enemyTanks.get(i);//获取到集合中的一个个坦克
            //判断当前坦克是否存活
            if (enemyTank.isLive()) { //当敌人坦克存活，才画出敌人坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), 1, enemyTank.getDirection(), g);

                //在绘制敌人坦克时，需要遍历敌人坦克对象Vector，绘制所有的子弹，当子弹存活为false时，就从Vector移除
                //遍历敌人坦克子弹集合Vector
                for (int j = 0; j < enemyTank.getShots().size(); j++) {
                    //拿到敌人坦克子弹集合中的子弹
                    Shot shot = enemyTank.getShots().get(j);
                    //判断子弹是否存活
                    if (shot.isLive()) {
                        //绘制子弹就是绘制当前子弹的坐标和长宽度
                        g.fill3DRect(shot.getX(), shot.getY(), 1, 1, false);
                    } else {
                        enemyTank.getShots().remove(shot);
                    }
                }
            }
        }

        //画子弹
        //判断子弹是否创建，并且是否存活
//        if (myTank.getShot() != null && myTank.getShot().isLive() == true){
//            g.fill3DRect(myTank.getShot().getX(), myTank.getShot().getY(), 1, 1, false);
//        }

        //将myTank的子弹集合遍历取出
        for (int i = 0; i < myTank.shots.size(); i++){
            Shot shot = myTank.shots.get(i);
            if (shot != null && shot.isLive()){
                g.fill3DRect(shot.getX(), shot.getY(), 1, 1, false);
            }else {
                //如果该shot对象已经无效，就从集合移除
                myTank.shots.remove(shot);
            }
        }

        //如果bombs 集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++){
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.getLife() > 6){
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            }else if(bomb.getLife() > 3){
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            }else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            //让这个炸弹的生命值减少
            bomb.LifeDown();
            //如果bomb life 为0，就从bombs 的集合中删除
            if (bomb.getLife() == 0){
                bombs.remove(bomb);
            }
        }

    }

    //判断敌方坦克击中我方坦克
    public void hitMyTanK(){
        //遍历敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank坦克的所有子弹
            for (int j = 0; j < enemyTank.getShots().size(); j++){
                Shot shot = enemyTank.getShots().get(j);
                //判断 shot是否击中我们的坦克
                if (myTank.isLive() && shot.isLive()){
                    hitTanK(shot, myTank);
                }
            }
        }
    }

    //判断子弹是否击中坦克
    public void hitTanK(Shot shot, Tank Tank){
        //判断shot 击中坦克
        switch (Tank.getDirection()){
            case 0://坦克向上
            case 2://坦克向下
                //判断子弹是否击中敌人坦克，击中就把子弹的存活，敌人坦克存活改为false
                if (shot.getX() > Tank.getX() && shot.getX() < Tank.getX() + 40
                        && shot.getY() > Tank.getY() && shot.getY() < Tank.getY() + 60){
                    shot.setLive(false);
                    Tank.setLive(false);
                    enemyTanks.remove(Tank);
                    //如果击中坦克，AllEnemyTanKNum++
                    //因为 Tank的类型是 MyTank 或者 EnemyTanK，所以要进行类型判断
                    if (Tank instanceof EnemyTank){
                        Recorder.addAllEnemyTanKNum();
                    }

                    //创建Bomb对象，加入到bombs中
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (shot.getX() > Tank.getX() && shot.getX() < Tank.getX() + 60
                        && shot.getY() > Tank.getY() && shot.getY() < Tank.getY() + 40){
                    shot.setLive(false);
                    Tank.setLive(false);
                    enemyTanks.remove(Tank);
                    //如果击中坦克，AllEnemyTanKNum++
                    //因为 Tank的类型是 MyTank 或者 EnemyTanK，所以要进行类型判断
                    if (Tank instanceof EnemyTank){
                        Recorder.addAllEnemyTanKNum();
                    }

                    //创建Bomb对象，加入到bombs中
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //如果我们的坦克可以发射多发子弹
    //判断多发子弹是否击中敌方坦克
    public void hitenemyTank(){
        //把我方子弹集合的子弹取出和敌方坦克进行判断
        for (int i = 0; i < myTank.shots.size(); i++){
            Shot shot = myTank.shots.get(i);//子弹集合的子弹

            //判断是否击中敌人坦克
            if (shot != null && shot.isLive()){ //当我的坦克子弹还存活
                //遍历敌人所有坦克
                for (int j = 0; j < enemyTanks.size(); j++){
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTanK(shot, enemyTank);
                }
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

        //当用户按下J时，发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J){
            //判断 myTank子弹是否消亡
            //如果myTank.getShot() == null，那么就说明还没创建子弹
            //线程销毁不代表着对象也置空，这是两个概念
            //第一次判断子弹是否创建，后面创建了就判断存活率是否为false
//            if (myTank.getShot() == null || !myTank.getShot().isLive()) { //发射一颗子弹
//                myTank.ShotFire();
//            }
            //发射多颗子弹
            myTank.ShotFire();
        }

        //让面板重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //通过线程的无限循环，让子弹不停重绘
    @Override
    public void run() {
        while (true){
            //每隔100毫秒重绘一次
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断我的坦克击中敌人坦克
            hitenemyTank();
            //判断敌人坦克击中我的坦克
            hitMyTanK();
            //让面板重绘
            repaint();
        }
    }
}
