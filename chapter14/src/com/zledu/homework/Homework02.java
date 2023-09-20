package com.zledu.homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {


        Car car1 = new Car("宝马", 3000000);
        Car car2 = new Car("宾利", 4000000);
        Car car3 = new Car("奔驰", 5000000);
        Car car4 = new Car("保时捷", 6000000);
        ArrayList arrayList = new ArrayList();
        //add：添加元素
        arrayList.add(car1);
        arrayList.add(car2);
        System.out.println(arrayList);

        //remove：删除指定元素
        arrayList.remove(car1);
        System.out.println(arrayList);

        //contains：查找元素是否存在
        System.out.println(arrayList.contains(car1));//false

        //size：获取元素的个数
        System.out.println(arrayList.size());//1

        //isEmpty：判断是否为空
        System.out.println(arrayList.isEmpty());//false

        //clear：清空
        //arrayList.clear();
        //System.out.println(arrayList);

        //addAll：添加多个元素
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(car3);
        arrayList2.add(car4);
        arrayList.addAll(arrayList2);
        System.out.println(arrayList);

        //containsAll：查找多个元素是否都存在
        System.out.println(arrayList.containsAll(arrayList2));//true

        //removeAll：删除多个元素
        arrayList.removeAll(arrayList2);
        System.out.println(arrayList);

        arrayList.addAll(arrayList2);
        System.out.println(arrayList);

        //增强for遍历
        System.out.println("===增强for遍历===");
        for (Object o : arrayList){
            System.out.println("o= " + o);
        }

        //迭代器遍历
        System.out.println("===迭代器遍历===");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("next=" + next);
        }


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
}