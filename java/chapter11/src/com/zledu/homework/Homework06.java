package com.zledu.homework;


public class Homework06 {
    public static void main(String[] args) {
        Person p1 = new Person("唐僧", new Horse());
        p1.passHorse();//马
        p1.passBoat();//船
        p1.passPlane();//飞机
        p1.passHorse();//马
        p1.passBoat();//船
        p1.passBoat();//船
        p1.passPlane();//飞机
    }
}
/*
1.有一个交通工具接口类Vehicles，有work接口
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获取交通工具Horse和Boat
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象”唐僧“，要求一般情况下用Horse作为交通工具，遇到过河时用Boat作为交通工具
扩展6.过火焰山，乘飞机
 */

interface Vehicles{
    //1.有一个交通工具接口类Vehicles，有work接口
    void work();
}
//2.有Horse类和Boat类分别实现Vehicles
class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下用Horse作为交通工具");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("遇到过河时用Boat作为交通工具");
    }
}
class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("遇到山用Plane作为交通工具");
    }
}
//3.创建交通工具工厂类，有两个方法分别获取交通工具Horse和Boat
class Vehiclesfactory{
    //马始终是同一匹马
    private static Horse horse = new Horse();//饿汉式

    private Vehiclesfactory(){} //把构造器私有化，不让创建对象
    //把两种方法添加static，这样调用就不用创建对象再调用了
    public static Horse getHorse(){
        //return new Horse();
        return horse;
    }
    public static Boat getBoat(){
        return new Boat();
    }
    public static Plane getPlane(){
        return new Plane();
    }
}
//4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
class Person{
    private String name;
    private Vehicles vehicles;

    //在创建人对象时，先给他分配交通工具
    //然后调用pass方法时，又新创建了一个交通工具，导致初始的交通工具浪费了(优化)
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    //5.实例化Person对象”唐僧“，要求一般情况下用Horse作为交通工具，遇到过河时用Boat作为交通工具
    //这里涉及到一个编程思想，就是可以把具体的要求，封装成方法
    //把两个交通工具分别封装成方法，调用Vehiclesfactory类的getHorse，getBoat创建对象调用work()
    public void passHorse(){
        //先得到马
        //判断 vehicles是否有交通工具，如果为null，就创建马，有就直接调用work()
        /**
         * 如何防止始终使用的是传入的马： 用instanceof判断
         * vehicles instanceof Horse 是判断 当前的 vehicles是不是Boat
         * (1) vehicles = null : vehicles instanceof Horse = false
         * (2) vehicles = 船对象 : vehicles instanceof Horse = false
         * (3) vehicles = 马对象 : vehicvv5les instanceof Horse = true
         */
        //if (vehicles == null) {
        if (!(vehicles instanceof Horse)){
            //这里使用的是多态
            vehicles = Vehiclesfactory.getHorse();
        }
        //这里体现使用接口调用
        vehicles.work();
    }
    public void passBoat(){
        //先得到船
        //判断 vehicles是否有交通工具，如果为null，就创建船，有就直接调用work()
        //if (vehicles == null) {
        if (!(vehicles instanceof Boat)){
            vehicles = Vehiclesfactory.getBoat();
        }
        vehicles.work();
    }
    public void passPlane(){
        if (!(vehicles instanceof Plane)){
             vehicles = Vehiclesfactory.getPlane();
        }
        vehicles.work();
    }
}