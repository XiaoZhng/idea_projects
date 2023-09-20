package com.zledu.homework;

/**
 * @author Alonso
 */
public class Homework02 {
    public static void main(String[] args) {
        /**
         * 1.有2个用户分别从用一个卡上取钱(总额10000)
         * 2.每次取1000，余额不足时，不能取款了
         * 3.不能出现超取现象
         */
        spend spend = new spend();
        new Thread(spend).start();
        new Thread(spend).start();
    }
}
class spend implements Runnable{
    private int monkey = 10000;
    private boolean loop = true;
    public synchronized void sell(){
        if (monkey <= 0){
            System.out.println("余额不足，不能取款了");
            loop = false;
            return;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户 " + Thread.currentThread().getName() + " 取款1000"
                + "，余额=" + (monkey -= 1000));
    }
    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(100);
                sell();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}