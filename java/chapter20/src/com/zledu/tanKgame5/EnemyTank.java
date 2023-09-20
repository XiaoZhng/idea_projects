package com.zledu.tanKgame5;

import java.util.Vector;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable{
    //创建Vector集合，保存子弹
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;//敌人坦克存活
    //在EneMyTank类增加一个成员，可以得到敌人坦克的Vector
    private Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    //这个 setEnemyTanks()作用是，在 MyPanel类调用时把 MyPanel类的敌人坦克集合传过来
    //MyPanel类: Vector<EnemyTank> enemyTanks = new Vector<>();
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前敌人坦克是否和 enemyTanks 集合中的坦克发生重叠
    public boolean isTouchEnemyTanK(){

        //用switch通过坦克方向来判断
        switch (this.getDirection()){
            case 0://当前坦克方向朝上
                //通过循环取到 enemyTanks集合中的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //取出的坦克不和自己比较
                    if (enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 40]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            //当前坦克左上角坐标[this.getX(), this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //当前坦克右上角坐标[this.getX() + 40, this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() +40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是右/左
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 60]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            //当前坦克左上角坐标[this.getX(), this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //当前坦克右上角坐标[this.getX() + 40, this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://当前坦克方向朝右
                //通过循环取到 enemyTanks集合中的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //取出的坦克不和自己比较
                    if (enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 40]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            //当前坦克右上角坐标[this.getX()+60, this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX() + 60, this.getY() + 40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() +40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是右/左
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 60]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            //当前坦克右上角坐标[this.getX() + 60, this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX() + 60, this.getY() + 40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://当前坦克方向朝下
                //通过循环取到 enemyTanks集合中的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //取出的坦克不和自己比较
                    if (enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 40]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            //当前坦克左下角坐标[this.getX(), this.getY() + 60]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX() + 40, this.getY() + 60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() +40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是右/左
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 60]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            //当前坦克左下角坐标[this.getX(), this.getY() + 60]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX() + 40, this.getY() + 60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://当前坦克方向朝左
                //通过循环取到 enemyTanks集合中的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //取出的坦克不和自己比较
                    if (enemyTank != this){
                        //如果敌人坦克方向是上/下
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 40]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            //当前坦克左上角坐标[this.getX(), this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //当前坦克左下角坐标[this.getX(), this.getY() + 40]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() +40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克方向是右/左
                        //敌人坦克X范围[enemyTanK.getX(), enemyTanK.getX() + 60]
                        //敌人坦克Y范围[enemyTanK.getY(), enemyTanK.getY() + 40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            //当前坦克左上角坐标[this.getX(), this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //当前坦克左下角坐标[this.getX(), this.getY() + 40]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        //如果没有重叠(即没有进入switch)
        return false;
    }
    @Override
    public void run() {
        while (true){

            //判断shots集合中是否有子弹，并且坦克是否存活，没有则创建
            if (shots.size() <= 1 && isLive){
                Shot s = null;
                //通过坦克方向来创建子弹
                switch (getDirection()){
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                //把创建的子弹放入集合
                shots.add(s);
                //启动子弹线程
                new Thread(s).start();
            }

            //根据坦克的方向来继续移动
            switch (getDirection()){
                case 0://向上
                    for (int i = 0; i < 30; i++) {
                        //规定移动范围
                        if (getY() > 0 && !isTouchEnemyTanK()) {
                            moveUp();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000 && !isTouchEnemyTanK()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750 && !isTouchEnemyTanK()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0 && !isTouchEnemyTanK()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //然后随机改变坦克的方向 0-3
            //setDirection(3);
            setDirection((int)(Math.random() * 4));

            //注意，写并发程序(多线程)，一定要考虑线程什么时候结束
            //当子弹击中坦克时，坦克停止移动，isLive==false
            if (!isLive){
                break;//退出线程
            }
        }
    }
}
