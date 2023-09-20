package com.zledu.Set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奔驰", 1005000));//ok
        linkedHashSet.add(new Car("宝马", 1000000));//ok
        linkedHashSet.add(new Car("奔驰", 1005000));//添加不了
        System.out.println("linkedHashSet=" + linkedHashSet);
    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    //name 和 price一样，则不能添加
    //重写Car类的hashCode(),使其name和price相同时，返回的hashCode值相同

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}