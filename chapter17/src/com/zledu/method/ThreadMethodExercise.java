package com.zledu.method;

/**
 * @author Alonso
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {

        Thread t3 = new Thread(new T3());
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5){
                t3.start();//当输出第5次hi时，启动子线程
                t3.join();//立即将子线程，插入到main，让子线程先执行
                System.out.println("子线程结束...");
            }
        }
        System.out.println("主线程结束...");
    }
}
class T3 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("hello " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}