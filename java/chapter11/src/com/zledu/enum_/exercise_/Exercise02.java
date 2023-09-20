package com.zledu.enum_.exercise_;

public class Exercise02 {
    public static void main(String[] args) {
        System.out.println(season2.SPRING);
        System.out.println(season2.SUMMER);
        System.out.println(season2.AAA);
        season2.f1();
    }
}
//enum关键字实现枚举类

/**
 * 1.用 enum关键字代替 class
 * 2.public static final season2 SPRING = new season2("春天", "温暖"); 可以直接使用SPRING("春天", "温暖");
 *   多个常量用 ,号间隔
 * 3.使用enum关键字定义枚举类，要求把定义的常量写在最前面
 */
enum season2{

//    public static final season2 SPRING = new season2("春天", "温暖");
//    public static final season2 SUMMER = new season2("夏天", "炎热");
//    public static final season2 AUTUMN = new season2("秋天", "凉爽");
//    public static final season2 WINTER = new season2("冬天", "寒冷");

    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷"), AAA();

    private String name;
    private String desc;
    private season2(){

    }
    private season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    public static void f1(){
        System.out.println("====");
    }

    @Override
    public String toString() {
        return "season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
