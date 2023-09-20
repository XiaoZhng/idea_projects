package com.zledu.tanKgame3;

//自己的坦克
public class MyTank extends Tank {
    //定义一个Shot对象，表示射击(线程)
    private Shot shot = null;
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
    public void ShotFire(){
        //通过switch控制坦克方向来创建子弹
        switch (getDirection()){
            case 0://上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://右
                shot = new Shot(getX() + 60, getY() +20, 1);
                break;
            case 2://下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //启动Shot线程
        new Thread(shot).start();
    }
}
