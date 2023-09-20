package com.zledu.tanKgame5;

/**
 * @author Alonso
 */
public class Shot implements Runnable{
    private int x;//子弹x坐标
    private int y;//子弹y坐标
    private int direction = 0;//子弹方向
    private int speed = 2;//子弹速度
    private boolean isLive = true;//子弹是否存活

    //构造器(创建子弹的时候就要给出x,y,direction)，速度可以是默认
    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while (true){
            //判断子弹移动到边界时，子弹销毁(线程销毁)
            //先写正确的，然后取反即可
            //当子弹碰到敌人坦克时，也应该结束线程
            if (!(x >= 0 && x <= 1000 & y >= 0 && y <= 750 && isLive)){
                //System.out.println("子弹到达边界，销毁...");
                isLive = false;
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //使用switch通过方向来改变子弹x,y
            switch (direction){
                case 0://上
                   y -= speed;//子弹的方向 - 子弹速度
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
            //System.out.println("子弹的x坐标=" + x + " y=" + y);
        }
    }
}
