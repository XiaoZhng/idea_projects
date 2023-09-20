package com.zledu.method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("jack");//修改线程名字
        t.setPriority(Thread.MIN_PRIORITY);//修改线程优先级
        t.start();//启动子线程

        //主线程打印5个"==="，就中断 子线程的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("===");
        }
        System.out.println(t.getName() + "的优先级= " + t.getPriority());//1
        t.interrupt();//中断 t线程的休眠
    }
}
class T extends Thread{//自定义线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子..." + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中...");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //当线程执行到一个interrupt 方法时，就会catch 一个异常，可以加入直接的业务代码
                System.out.println(Thread.currentThread().getName() + " 被 interrupt了");
            }
        }
    }
}