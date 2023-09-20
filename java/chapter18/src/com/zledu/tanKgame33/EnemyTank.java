package com.zledu.tanKgame33;

import java.util.Vector;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable{
    //定义一个 Vector集合，存放子弹
    Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
    }

    @Override
    public void run() {
        while (true) {
        //当敌人坦克没有消亡，并且敌人坦克子弹集合中没有子弹了，就创建一颗子弹
        if (isLive && shots.size() == 0){
            Shot shot = null;
            //根据坦克方向创建子弹
            switch (getDirection()){
                case 0://上
                    shot = new Shot(getX() + 20, getY(), 0);
                    break;
                case 1://右
                    shot = new Shot(getX() + 60, getY() + 20, 1);
                    break;
                case 2://下
                    shot = new Shot(getX() + 20, getY() + 60, 2);
                    break;
                case 3://左
                    shot = new Shot(getX(), getY() + 20, 3);
                    break;
            }
            //创建了子弹，就放入集合中
            shots.add(shot);
            //启动子弹线程
            new Thread(shot).start();
        }

            //根据坦克的方向来移动
            switch (getDirection()) {
                case 0://上
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://右
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
                case 2://下
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
                case 3://左
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
            //然后随机改变坦克的方向
            setDirection((int)(Math.random() * 4));

            //如果坦克消亡，则停止移动
            if (!isLive){
                break;
            }
        }
    }
}
