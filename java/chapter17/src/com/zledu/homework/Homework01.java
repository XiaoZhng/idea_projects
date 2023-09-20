package com.zledu.homework;

import java.util.Scanner;

/**
 * @author Alonso
 */
public class Homework01 {
    public static void main(String[] args) {
        /**
         * 1.main方法启动两个线程
         * 2.第1个线程循环随机打印100以内的整数
         * 3.直到第2个线程从键盘读取 "Q" 命令
         */

        //测试
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
class A extends Thread{
    private boolean loop = true;

    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(1000);
                System.out.println((int)(1 + Math.random() * (100 - 1 + 1)));
                //System.out.println((int)(Math.random() * (100 + 1)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a线程结束...");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
class B extends Thread{
    //持有a线程，才能修改a线程
    private A a;
    Scanner scanner = new Scanner(System.in);

    public B(A a){
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入命令：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                //以通知方式结束a线程，调用a线程的setLoop()
                a.setLoop(false);
                System.out.println("b线程结束...");
                break;
            }
        }
    }
}