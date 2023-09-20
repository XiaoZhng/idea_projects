package com.zledu.static_;

public class ChildGame {
    public static void main(String[] args) {
        //定义一个遍历count，统计有多少小孩加入游戏

        Child child1 = new Child("tim");
        child1.join();
        child1.count++;

        Child child2 = new Child("tom");
        child2.join();
        child2.count++;

        Child child3 = new Child("king");
        child3.join();
        child3.count++;

        //类变量可以通过类名来访问
        System.out.println("共有" + Child.count + "个小孩加入游戏");
        System.out.println("child1.count=" + child1.count);
        System.out.println("child2.count=" + child2.count);
        System.out.println("child3.count=" + child3.count);
    }
}

class Child{
    private String name;
    //定义一个变量count，是一个类变量(静态变量) static 静态
    //该变量最大的特点就是会被child类的所有的对象实例共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }
    public void join(){
        System.out.println(name + "加入游戏");
    }
}