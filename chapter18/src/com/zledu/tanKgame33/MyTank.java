package com.zledu.tanKgame33;

//自己的坦克
public class MyTank extends Tank {
    //定义一个子弹类
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

    //编写一个发射子弹的方法
    public void ShotFire(){
        //根据自己坦克的方向来判断子弹的方向
        switch (getDirection()){
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //子弹创建好后，启动线程
        new Thread(shot).start();
    }
}
