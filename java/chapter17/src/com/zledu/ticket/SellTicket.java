package com.zledu.ticket;

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
        SellTicket2 sellTicket2 = new SellTicket2();
        new Thread(sellTicket2).start();
        new Thread(sellTicket2).start();
        new Thread(sellTicket2).start();

    }
}

//使用继承 Thread方式
class SellTicket1 extends Thread{
    private static int TicketNum = 100;//车票数
    @Override
    public void run() {
        while (true){
            //判断车票 <= 0时，退出循环
            if (TicketNum <= 0){
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
class SellTicket2 implements Runnable{
    private int TicketNum = 100;//车票数
    @Override
    public void run() {
        while (true){
            //判断车票 <= 0时，退出循环
            if (TicketNum <= 0){
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