package com.zledu.interFace_.exercise_;

import com.zledu.interFace_.ex.test;

public class Exercise01 {
    public static void main(String[] args) {

        test test = new test();



        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();
        //遍历数组
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            //类型判断
            //instanceof 判断的是 运行类型
            if (usbs[i] instanceof Phone){
//                Phone phone = (Phone)usbs[i];
//                phone.call();
                ((Phone)usbs[i]).call();
            }
        }
    }
}
interface Usb{
    public void work();
}
class Phone implements Usb{
    public void call(){
        System.out.println("phone call()...");
    }

    @Override
    public void work() {
        System.out.println("phone work()...");
    }
}
class Camera implements Usb{
    @Override
    public void work() {
        System.out.println("camera work()...");
    }
}