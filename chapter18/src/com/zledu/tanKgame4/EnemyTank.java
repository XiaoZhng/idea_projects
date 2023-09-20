package com.zledu.tanKgame4;

import java.util.Vector;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable{
    //创建Vector集合，保存子弹
    private Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;//敌人坦克存活
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
                        if (getY() > 0 ) {
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
                        if (getX() + 60 < 1000) {
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
                        if (getY() + 60 < 750) {
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
                        if (getX() > 0) {
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
