package com.zledu.syn;

public class SellTicket {
    public static void main(String[] args) {
        //创建三个对象，三个窗口
//        SellTicket1 sellTicket1 = new SellTicket1();
//        SellTicket1 sellTicket2 = new SellTicket1();
//        SellTicket1 sellTicket3 = new SellTicket1();
//        //使用继承 Thread方式，创建对象实例后可以直接调用 start()，不用再去创建Thread对象再调用
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();

        //使用 Runnable接口方式
//        SellTicket2 sellTicket2 = new SellTicket2();
//        new Thread(sellTicket2).start();
//        new Thread(sellTicket2).start();
//        new Thread(sellTicket2).start();

        //线程同步机制测试
        SellTicket3 sellTicket3 = new SellTicket3();
        new Thread(sellTicket3).start();
        new Thread(sellTicket3).start();
        new Thread(sellTicket3).start();

        /**
         * 遇到的问题：
         * 一直是一个窗口在售票的原因：因为sell方法加入了 synchronized，所以在同一时刻，只能有一个线程来执行sell方法
         * 直到第一个线程操作执行完，其他线程才能操作，而第一个线程执行完循环就结束了，所以其他线程也就没有执行。
         * 解决办法：在run方法加个休眠时间即可，让线程0进去后先休眠，休眠的时候，其他线程先执行，然后休眠完后在执行线程0
         */
    }
}

//使用 Runnable接口方式，使用线程同步机制
class SellTicket3 implements Runnable {
    private int TicketNum = 100;//车票数
    private boolean loop = true;//控制run方法的变量
    Object object = new Object();

    //同步方法(静态)的锁为当前类本身
    //解读：
    //1.public synchronized static void m1() {} 锁是加在 SellTicket3.class
    //2.如果在静态方法中，实现一个同步代码块
    /*
        public static void m2() {
            synchronized (SellTicket3.class) {
                System.out.println("m2");
            }
        }
     */
    public synchronized static void m1() {
    }

    public static void m2() {
        synchronized (SellTicket3.class) {
            System.out.println("m2");
        }
    }

    //说明
    //1.public synchronized void sell() {} 这是一个同步方法
    //2.这是锁在 this对象
    //3.也可以在代码块上写 synchronized，同步代码块，互斥锁还是在this对象
    public /*synchronized*/ void sell() { //同步方法，在同一时刻，只能有一个线程来执行sell方法
        synchronized (/*this*/ object) { //object是同一对象
            //判断车票 <= 0时，退出循环
            if (TicketNum <= 0) {
                System.out.println("===售票结束====");
                loop = false;
                return;
            }
            //休眠50毫秒
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + ",出售了一张票"
                    + ",剩余票数=" + (--TicketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(100);
                sell();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//使用继承 Thread方式
class SellTicket1 extends Thread {
    private static int TicketNum = 100;//车票数

    /**
     * 这里的this合不合理，主要看这个类创建了几个对象来调用线程
     * new SellTicket1().start();
     * new SellTicket1().start();
     * 如果创建多个对象来调用线程，那么这个互斥锁就没有用
     *
     * SellTicket1 sellTicket1 = new SellTicket1();
     * new Thread(sellTicket1).start();
     * new Thread(sellTicket1).start();
     * 如果是同一个对象调用多个线程，那么这个this就是指向同一对象
     */
    public void m3(){
        synchronized (this) {
            System.out.println("m3");
        }
    }

    @Override
    public void run() {
        while (true) {
            //判断车票 <= 0时，退出循环
            if (TicketNum <= 0) {
                System.out.println("===售票结束====");
                break;
            }

            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + ",出售了一张票"
                    + ",剩余票数=" + (--TicketNum));
        }
    }
}

//使用 Runnable接口方式
class SellTicket2 implements Runnable {
    private int TicketNum = 100;//车票数

    @Override
    public void run() {
        while (true) {
            //判断车票 <= 0时，退出循环
            if (TicketNum <= 0) {
                System.out.println("===售票结束====");
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + ",出售了一张票"
                    + ",剩余票数=" + (--TicketNum));
        }
    }
}