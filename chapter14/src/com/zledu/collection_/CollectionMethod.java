package com.zledu.collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        //add:添加单个元素
        list.add("jack");
        list.add(10);
        list.add(true);
        System.out.println("list=" + list);
        //remove:删除指定元素
        list.remove(true);//指定删除某个元素
        //list.remove(0);//指定删除第一个元素
        System.out.println("list=" + list);
        //contains:查找元素是否存在
        System.out.println(list.contains("jack"));//t
        //size:查找元素个数
        System.out.println(list.size());//2
        //isEmpty:判断是否为空
        System.out.println(list.isEmpty());//f
        //clear:清空
        list.clear();
        //System.out.println(list);
        //addAll:添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("心流");
        list2.add("被讨厌的勇气");
        list.addAll(list2);
        System.out.println("list=" + list);
        //containsAll:查找多个元素是否存在
        System.out.println(list.containsAll(list2));//t
        //removeAll:删除多个元素
        list.add("三体");
        list.removeAll(list2);
        System.out.println("list=" + list);//[三体]
    }
}
