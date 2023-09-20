package com.zledu.single_;

public class SingleTon01 {
    public static void main(String[] args) {
//        girlFriend jack = new girlFriend("jack");
//        girlFriend king = new girlFriend("king");

//        System.out.println(girlFriend.getInstance());
        System.out.println(girlFriend.n1);
    }
}

class girlFriend{
    private String name;
    public static int n1 = 100;
    //为了能够在静态方法中，返回gf对象，需要将其修饰为static
    //对象，通常是重量级的对象，饿汉式可能造成创建了对象，但是没有用
    private static girlFriend gf = new girlFriend("jack");
    //如何保障我们只能创建一个 girlFriend对象? [单例模式-饿汉式]
    //1.将构造器私有化
    //2.在类的内部直接创建(该对象是static)
    //3.提供一个公共的static方法，返回gf对象
    private girlFriend(String name) {
        System.out.println("gzq调用");
        this.name = name;
    }

    public static girlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "girlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}