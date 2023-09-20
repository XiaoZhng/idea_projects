package com.zledu.homework;

import javafx.scene.control.Cell;

public class homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        //1.匿名内部类是
        /*
            new IComputer() {
                @Override
                public double work(double n1, double n2) {
                    return n1 + n2;
                }
            }，同时也是一个对象
            它的编译类型就是 IComputer 运行类型就是 匿名内部类
         */
        cellphone.testWork(new IComputer() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },2, 3);
    }
}

interface IComputer{
    public double work(double n1, double n2);
}
class Cellphone{
    //定义方法，调用接口的work方法
    //解读：当我们调用testWork方法时，直接传入一个实现了IComputer接口的匿名内部类即可
    //该匿名内部类，可以灵活的实现work，完成不同的计算任务
    public void testWork(IComputer icomputer, double n1, double n2){
        double result =  icomputer.work(n1, n2);//动态绑定
        System.out.println("计算结果：" + result);
    }
}