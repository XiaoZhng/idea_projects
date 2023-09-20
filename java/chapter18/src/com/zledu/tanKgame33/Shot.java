package com.zledu.tanKgame33;

/**
 * @author Alonso
 * 子弹类
 */
//把子弹类设置为线程
public class Shot implements Runnable{
    private int x;
    private int y;
    private int direction;//方向
    private int speed = 2;//速度
    private boolean isLive = true;//存活率

    //创建子弹，只需要确定x,y,方向
    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //子弹达到边界销毁
            //加个判断条件，当子弹存活率为false时，子弹销毁
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)){
                System.out.println("子弹达到边界，销毁...");
                isLive = false;
                break;
            }

            //通过坦克的方向，来判断子弹发射的方向和速度
            switch (getDirection()){
                case 0://上
                    //y = y - speed;
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            System.out.println("子弹坐标x=" + x + " y=" + y);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
