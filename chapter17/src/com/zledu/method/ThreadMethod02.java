package com.zledu.method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟)在运行" + i);
            if (i == 5){
                System.out.println("主线程(小弟)让 子线程(老大)在运行");
                //join(); //线程插队
                //t2.join();//这里相当于让t2 线程先执行完毕
                Thread.yield();//礼让，不一定成功
                System.out.println("子线程(老大)运行完，主线程(小弟)再运行");
            }
        }
    }
}
class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("子线程(老大)在运行" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}