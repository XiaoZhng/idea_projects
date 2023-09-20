package com.zledu.tanKgame33;

/**
 * @author Alonso
 */
public class Bomb {
    private int x;
    private int y;
    private boolean isLive = true;
    private int life = 9;//爆炸的生命周期

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

    public boolean getLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    //编写方法，判断生命周期大于0，就--，小于0，存活率为false
    public void life(){
        if (life > 0){
            life--;
        }else {
            isLive = false;
        }
    }
}
