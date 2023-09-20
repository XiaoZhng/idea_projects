package com.zledu.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {

        /**
         * 泛型的继承和通配符
         * (1) 泛型不具备继承性
         * (2) List<?>，可以接收任意的泛型类型
         * (3)List<? extends A> 可以接收A类以及A类的子类，规定了泛型的上限
         * (4)List<? super A> 可以接收A类以及A类的父类，不限于直接父类，规定了泛型的下限
         */

        //泛型不具备继承性
        //ArrayList<Object> list = new ArrayList<String>();

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();

        //三种方法的使用
        //如果是 List<?> c，可以接收任意的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA> 可以接收 AA或者AA的子类
//        printCollection2(list1);//×
//        printCollection2(list2);//×
        printCollection2(list3);//√
        printCollection2(list4);//√
        printCollection2(list5);//√

        //List<? super AA> 可以接收 AA或者AA的父类
        printCollection3(list1);//√
//        printCollection3(list2);//×
        printCollection3(list3);//√
//        printCollection3(list4);//×
//        printCollection3(list5);//×
    }

    //说明：List<?> 表示 任意的泛型类型都可以接收
    public static void printCollection1(List<?> c){
        for (Object o :c) { //通配符，取出时，就是Object
            System.out.println(o);
        }
    }

    //起到 约束的作用

    //说明：List<? extends AA> 表示 上限，可以接收 AA或者AA的子类
    public static void printCollection2(List<? extends AA> c){
        for (Object o :c) {
            System.out.println(o);
        }
    }

    //说明：List<? super AA> 表示 下限，可以接收 AA或者AA的父类
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c){
        for (Object o :c) {
            System.out.println(o);
        }
    }
}
class AA{}
class BB extends AA{}
class CC extends BB{}