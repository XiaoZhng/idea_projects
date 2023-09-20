package com.zledu.object_;

public class ToString_ {
    public static void main(String[] args) {
        /*
        Object的toString()源码
        (1)getClass().getName() 类的全类名(包名+类名)
        (2)Integer.toHexString(hashCode()) 将对象的hashCode值转成16进制字符串
        * public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }*/
        Monster monster = new Monster("tom", "设计师", 5000);
        System.out.println(monster.toString() + " hashCode= " + monster.hashCode());

        System.out.println("--当直接输出一个对象时，toString() 方法会被默认的调用--");
        System.out.println(monster); //等价 monster.toString()
    }
}

class Monster{
    private String name;
    private String job;
    private double salary;

    public Monster(String name, String job, double salaty){
        this.name = name;
        this.job = job;
        this.salary = salaty;
    }

    //重写toString方法，输出对象的属性
    @Override
    public String toString() { //重写后，一般是把对象的属性值输出，当然也可以自己定制
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}