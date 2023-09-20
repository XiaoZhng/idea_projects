package com.zledu.collection_;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection list = new ArrayList();
        list.add(new Book("心流", "米哈里", 49.0));
        list.add(new Book("三体", "刘慈欣", 35.9));
        list.add(new Book("三体2", "刘慈欣", 39.9));

        //1.使用增强for，在Collection集合
        //2.增强for，底层仍然是迭代器
        //3.增强for可以理解成是简化版本的 迭代器遍历
        //4.快捷键: I
        for (Object book : list){
            System.out.println("book= " + book);
        }

        //增强for，也可以直接在数组使用
//        int[] num = {1,2,3,4,5};
//        for (int i : num){
//            System.out.println("i=" + i);
//        }

    }
}
