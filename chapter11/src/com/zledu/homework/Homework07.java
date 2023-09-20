package com.zledu.homework;

public class Homework07 {
    public static void main(String[] args) {
        Car car = new Car(33.3);
        car.getAir().flow();
    }
}

class Car{
    private double tempeerature;

    public Car(double tempeerature) {
        this.tempeerature = tempeerature;
    }

    class Air{ //成员内部类
        //吹风功能
        public void flow(){
            if (tempeerature > 40){
                System.out.println("吹冷风...");
            }else if(tempeerature < 0){
                System.out.println("吹暖气...");
            }else {
                System.out.println("关掉空调");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }
}