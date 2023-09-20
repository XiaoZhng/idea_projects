package com.boot.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alonso
 */
public class test1 {
    public static void main(String[] args) {
        Integer[] integers = arraySort(10, 70);
        System.out.println(Arrays.toString(integers));

//        char my = 'g';
//        String string = Character.toString(my);
//        System.out.println(string);
//        string = String.valueOf(my);
//        System.out.println(string);

//        Integer[] integers = sorteRandom(10, 90);
//        System.out.println(Arrays.toString(integers));
    }

    /**
     * 返回互异随机数
     * @param n 数组长度
     * @param size 随机数范围
     * @return
     */
    /*
        1.先对参数进行验证，不正确就抛异常
        2.创建长度为 n 的数组
        3.创建set集合(set集合是不允许值重复的)
        4.通过循环把随机数存入set集合中，当集合的长度大于数组长度时，退出循环
        5.遍历集合，把集合中随机数存入数组中
        6.数组排序，冒泡、快排、sort等
         */
    public static Integer[] arraySort(int n, int size){
        //校验，参数不正确抛异常
        if (n < 1 || size < 1 || size < n){
            throw new RuntimeException("参数异常...");
        }

        //创建长度为 n 的数组
        Integer[] array = new Integer[n];
        //创建set集合
        Set<Integer> set = new HashSet<>();
        //往集合里添加随机数，当集合长度大于数组长度时，循环结束
        while (set.size() < n){
            int num = (int) (Math.random() * size);
            set.add(num);
        }

        //临时变量
        int temp = 0;

        //取出set集合中的每一个元素，放入数组中，当数组满时，停止遍历
        for (Integer sets : set) {
            array[temp] = sets;
            if (temp < n){
                temp++;
            }
        }

        //排序
        Arrays.sort(array);

        return array;
    }

    //返回n个排序的互异随机数
    public Integer[] differentSortedRandom(int n, int size){


        return null;
    }
}
