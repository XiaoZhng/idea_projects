package com.zledu.method;

/**
 * @author Alonso
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束
        //只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);//设置为守护线程
        myDaemonThread.start();

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("主线程在运行..." + i);
        }
    }
}
class MyDaemonThread extends Thread{
    @Override
    public void run() {
        for (; ;){//无限循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程在运行...");
        }
    }
}