package com.zledu.homework;

/**
 * @author Alonso
 */
public class Homework03 {
    public static void main(String[] args) {
        /**
         * 1.有2个用户分别从用一个卡上取钱(总额10000)
         * 2.每次取1000，余额不足时，不能取款了
         * 3.不能出现超取现象
         */

        T t = new T();
        new Thread(t).start();
        new Thread(t).start();
    }
}

//1.因为这里涉及到多个线程共享资源，所以使用实现Runnable方式
//2.每次取出 1000
class T implements Runnable{
    private int money = 10000;

    @Override
    public void run() {
        while (true){

            //解读：
            //1.这里使用 synchronized 实现了线程同步
            //2.当多个线程执行到这里时，就回去夺取 this对象锁
            //3.哪个线程夺到(获取)this对象锁，就执行 synchronized 代码块，执行完后，会释放this对象锁
            //4.夺取不到this对象锁，就 blocked，准备继续争夺
            //5.this对象锁是非公平锁

            synchronized (this) {
                //判断余额不足情况
                if (money < 1000) {
                    System.out.println("余额不足，不能取款");
                    break;
                }

                money -= 1000;
                System.out.println("用户 " + Thread.currentThread().getName() + "取款1000" +
                        " 余额=" + money);
            }
            //休眠1000毫秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}