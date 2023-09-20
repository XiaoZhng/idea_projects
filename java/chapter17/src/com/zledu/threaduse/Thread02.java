package com.zledu.threaduse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();//这里不能调用start()
        //dog.run();
        //创建了Thread对象，把dog对象(实现了Runnable接口)，放入Thread
        //Thread thread = new Thread(dog);
        //thread.start();
        //new Thread(dog).start(); //小狗汪汪叫...1 Thread-0

//        Tiger tiger = new Tiger();
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
//        threadProxy.strat();

        //new Thread(new Tiger()).start();
        ThreadProxy threadProxy = new ThreadProxy(new Tiger());
        threadProxy.strat(); //老虎嗷嗷叫...

        /**
         * (1) Tiger tiger = new Tiger();
         * 创建 Tiger对象，Tiger继承了 Animal，因为java是单继承机制，所以实现Runnable 接口
         * (2) ThreadProxy threadProxy = new ThreadProxy(tiger);
         * 创建 ThreadProxy对象，把 Tiger放入 ThreadProxy对象
         * (3) threadProxy.strat();
         * 调用 start()，里面会调用 start0()，然后会调用本类的 run()
         * 因为 target = Tiger对象，所以不为null，就会动态绑定 Tiger类的run()
         */
    }
}

class Animal{}
class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}

//创建一个静态代理模式类
//这里可以把 ThreadProxy 当做 Thread
class ThreadProxy implements Runnable{

    private Runnable target = null;//属性，类型是 Runnable

    @Override
    public void run() {
        if (target != null){
            target.run();
        }
    }

    public ThreadProxy(Runnable target) { //构造器
        this.target = target;
    }

    public void strat(){
        start0();
    }
    public void start0(){
        run();
    }
}

class Dog implements Runnable{ //通过实现 Runnable接口，开发线程

    int count = 0;
    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..." + (++count) + Thread.currentThread().getName());
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10){
                break;
            }
        }
    }
}