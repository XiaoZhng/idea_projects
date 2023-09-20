package com.zledu.homeworks_;

public class Homeworks07 {
    public static void main(String[] args) {
        Car car1 = new Car(66.1);
        car1.m1().flow();
        Car car2 = new Car(20);
        car2.m1().flow();
    }
}
class Car{
    private double temperature;//温度

    public Car(double temperature) {
        this.temperature = temperature;
    }

    //成员内部类
    class Air{
        public void flow(){
            if (temperature > 40){
                System.out.println("超过40°，吹冷气...");
            }else if(temperature < 0){
                System.out.println("低于0°，吹暖气...");
            }else {
                System.out.println("温度正常...");
            }
        }
    }
    public Air m1(){
        return new Air();
    }
}