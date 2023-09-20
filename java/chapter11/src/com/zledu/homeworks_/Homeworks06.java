package com.zledu.homeworks_;

public class Homeworks06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.passHorse();
        person.passriver();
        person.passHorse();
        person.passriver();
        person.passPlane();
        person.passriver();
    }
}
interface Vehicles{ //工具类
    void work();
}
class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下，马为交通工具");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("遇到河流，船为交通工具");
    }
}
class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("遇到火焰山，飞机为交通工具");
    }
}
class factory{ //工厂类
    private static Horse horse = new Horse();//饿汉式解决方法

    //构造器私有化，防止直接new
    private factory() {
    }

    //直接从工厂类取出交通工具，所以设置为静态方法，返回交通工具对象
    public static Horse horse(){
//        return new Horse();
        return horse;
    }
    public static Boat Boat(){
        return new Boat();
    }
    public static Plane plane(){
        return new Plane();
    }
}

//改进：如何不浪费创建person对象时创建的交通工具？ 在创建马船对象时进行判断
//防止传入的始终是一匹马 进行类型判断 instanceof
//如歌解决白龙马从始至终都是一匹，不更换马对象
//遇到火焰山，使用飞机通过

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    //实例化对象”唐僧“，要求在一般情况下，用horse作为交通工具，遇到河流Boat作为交通工具
    //这里有个编程方法，把这个需求封装成方法
    public void passHorse(){
        //一般情况下，获取到马
        //判断 vehicles 是否已经存在
        //如果 vehicles 不是马对象就创建马对象
        if (!(vehicles instanceof Horse)){
            vehicles = factory.horse();
        }
        vehicles.work();
    }
    public void passriver(){
        //遇到河流，获取到船
        //判断 vehicles 是否已经存在
        //如果 vehicles 不是船对象就创建船对象
        if (!(vehicles instanceof Boat)){
            vehicles = factory.Boat();
        }
        vehicles.work();
    }
    public void passPlane(){
        if (!(vehicles instanceof Plane)){
            vehicles = factory.plane();
        }
        vehicles.work();
    }
}
