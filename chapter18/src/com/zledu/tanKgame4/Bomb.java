package com.zledu.tanKgame4;

/**
 * @author Alonso
 */
public class Bomb {
    private int x,y;//xy坐标
    private int life = 9;//爆炸的生命周期
    private boolean isLive = true;//存活率

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    //减少生命值
    public void LifeDown(){
        if (life > 0){
            life--;
        }else { //生命中小于0，存活率为false
            isLive = false;
        }
    }
}
