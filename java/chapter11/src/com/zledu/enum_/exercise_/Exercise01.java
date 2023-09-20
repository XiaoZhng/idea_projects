package com.zledu.enum_.exercise_;

public class Exercise01 {
    public static void main(String[] args) {
//        season spring = new season("春天", "温暖");
//        season summer = new season("夏天", "炎热");
//        season autumn = new season("秋天", "凉爽");
//        season winter = new season("东天", "寒冷");
//        season outher = new season("其他天", "===");

        //自定义枚举类
        //内部创建的对象是 static，所以可以通过类名.对象名 直接访问
        System.out.println(season.AUTUMN);
        System.out.println(season.WINTER);
    }
}

//自定义枚举类

/**
 * 1.构造器私有化
 * 2.去除修改，去除setter方法,保留只读
 * 3.在类内部创建并暴露固定的对象
 */
class season{
    private String name;
    private String desc;

    public static final season SPRING = new season("春天", "温暖");
    public static final season SUMMER = new season("夏天", "炎热");
    public static final season AUTUMN = new season("秋天", "凉爽");
    public static final season WINTER = new season("冬天", "寒冷");

    private season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}