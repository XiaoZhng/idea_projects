package com.zledu.enum_;

//使用enum关键字实现枚举类

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.WINTER);
//        Season2 boy = Season2.SPRING;
//        System.out.println(boy);
    }
}

enum Season2{


    //定义了四个对象
//    public static final Season SPRING = new Season("春天", "暖和的");
//    public static final Season SUMMER = new Season("夏天", "炎热的");
//    public static final Season AUTUMN = new Season("秋天", "凉爽的");
//    public static final Season WINTER = new Season("冬天", "寒冷的");

    //如果使用emun 来实现枚举类

    /**
     * 1.使用关键字enum 替代 class
     * 2.public static final Season SPRING = new Season("春天", "暖和的");
     * 直接使用 SPRING("春天", "暖和的") 解读 常量名(实参列表)
     * 3.如果有多个常量(对象)，使用  ,号间隔即可
     * 4.如果使用enum来实现枚举类，要求将定义的常量对象，写在前面
     * 5.如果我们使用的是无参构造器，创建常量对象，则可以省略()
     */
    SPRING("春天", "暖和的"),SUMMER("夏天", "炎热的"),
    AUTUMN("秋天", "凉爽的"),WINTER("冬天", "寒冷的");
    private String name;
    private String desc;//描述

    private Season2(){//无参构造器

    }
    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
