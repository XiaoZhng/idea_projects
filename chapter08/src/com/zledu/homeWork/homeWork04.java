package com.zledu.homeWork;

public class homeWork04 {
    public static void main(String[] args) {
        Manager manager = new Manager("jack", 100, 20, 1.2);
        //设置奖金
        manager.setBonus(3000);
        //打印经理的工资的情况
        manager.printSal();

        Worker worker = new Worker("tom", 50, 10, 1.0);
        worker.printSal();
    }
}
