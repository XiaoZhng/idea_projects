package com.zledu.tanKgame33;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direction;//坦克的方向
    private int speed = 2;//坦克的速度
    private boolean isLive = true;//坦克存活率

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        y -= speed;
    }
    public void moveRight(){
        x += speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }

    public int getSpeed(int speed) {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
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

    public boolean getLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
