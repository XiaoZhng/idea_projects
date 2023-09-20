package com.zledu.poly_;

public class test {
    public static void main(String[] args) {
        Car car = new Car();
        car.set_number(3888);
        car.show_number();
    }
}

class Car{
    int car_number;
    public void set_number(int car_num){
        car_number = car_num;
    }
    public void show_number(){
        System.out.println("is: "+ car_number);
    }
}