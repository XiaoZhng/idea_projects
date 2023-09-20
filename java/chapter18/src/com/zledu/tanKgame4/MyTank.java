package com.zledu.tanKgame4;

import java.util.Vector;

//自己的坦克
public class MyTank extends Tank {
    //定义一个Shot对象，表示射击(线程)
    private Shot shot = null;
    //使用Vector集合保存多颗子弹
    Vector<Shot> shots = new Vector<>();

    public MyTank(int x, int y) {
        super(x, y);
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    //射击
    public void ShotFire() {

        //控制子弹数只有5颗
        if (shots.size() == 5){
            return;
        }

        //通过switch控制坦克方向来创建子弹
        switch (getDirection()) {
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
        //每创建一颗子弹就把放入集合
        shots.add(shot);
        //启动Shot线程
        new Thread(shot).start();
    }
}
