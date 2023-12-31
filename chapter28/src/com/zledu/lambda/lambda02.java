package com.zledu.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Alonso
 * lambda表达式的使用
 */
public class lambda02 {

    /**
     * lambda表达式的使用
     *
     * 1.举例：(o1,o2) -> Integer.compare(o1,o2);
     * 2.格式：
     *      ->：lambda操作符 或 箭头操作符
     *      ->左边：lambda形参列表 (其实就是接口中的抽象方法的形参列表)
     *      ->右边：lambda体 (其实就是重写的抽象方法的方法体)
     *
     * 3.分六种情况介绍
     *
     * 总结：
     *      ->左边：lambda形参列表的参数类型可以省略(类型推断)，如果lambda形参列表只有一个参数，也其一对()可以省略
     *      ->右边：lambda体应该使用一对{}包裹，如果lambda体只有一条执行语句(可能是return语句)，省略这一对{}和return关键字
     *
     * 4.lambda表达式的本质：作为接口的实例
     *
     * 5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口，我们可以在一个接口上使用 @FunctionalInterface 注解，
     * 这样做可以检查它石否是一个函数式接口
     *
     * 6.所以以前用匿名实现类表示的，现在都可以用lambda表达式来写
     */

    @Test
    public void test1(){

        //语法格式一：无参，无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        };
        r1.run();
        System.out.println("=========================");

        Runnable r2 = () -> {
            System.out.println("hi lambda");
        };
        r2.run();
    }

    @Test
    public void test2(){

        //语法格式二：lambda需要一个参数，但是没有返回值
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("你好吗？");
        System.out.println("=========================");

        Consumer<String> con2 = (String s) -> {
            System.out.println(s);
        };
        con2.accept("我很好!");
    }

    @Test
    public void test3(){

        //语法格式三：数据类型可以省略，因为可有编译器推断得出，称为 类型推断
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("tom");
        System.out.println("=========================");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("jack");

        ArrayList<String> arrayList = new ArrayList<>();//类型推断
        int[] n1 = new int[]{1,2,3};
        int[] n2 = {1,2,3};//类型推断
    }

    @Test
    public void test4(){

        //语法格式四：lambda 若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("tom");
        System.out.println("=========================");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("kk");
    }

    @Test
    public void test5(){

        //语法格式五：lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,32));
        System.out.println("=========================");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(33,22));
    }

    @Test
    public void test6(){

        //语法格式六：当lambda只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,32));
        System.out.println("=========================");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(32,21));
    }
}

//函数式接口
@FunctionalInterface
interface IA{
    void m1();
//    void m2();
}