package com.zledu.homework;

import java.util.TreeSet;

public class Homework05 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());//因为返回的是0,底层认为是相同对象，所以加入不了
        treeSet.add(new Person());//抛出异常 ClassCastException
        //因为 add方法，TreeSet() 构造器没有传入Compareable接口的匿名内部类， 即：Person类没有实现 Compareable接口
        //TreeSet 底层会根据传入的对象实现的 Comparablej接口的 compareTo()来比较，即把Person转成 Comparable类型
        // Comparable<? super K> k = (Comparable<? super K>) key;
        //如果没有实现 Comparablej接，则抛出异常 ClassCastException
        System.out.println(treeSet);
    }
}
class Person implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}