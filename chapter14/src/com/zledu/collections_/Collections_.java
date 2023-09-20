package com.zledu.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //创建ArrayList 集合，用于测试
        ArrayList list = new ArrayList();
        list.add("jack");
        list.add("tm");
        list.add("lucy");
        System.out.println(list);

        //reverse:反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);

        //shuffle:对 List 集合元素进行随机排序
        //Collections.shuffle(list);
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println("集合元素进行随机排序= " + list);
        }
        System.out.println("=============");

        //sort:根据元素的自然排序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println("自然排序= " + list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("自然排序后= " + list);

        //swap:将指定 List 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list, 0, 1);
        System.out.println("交换后= " + list);

        //Object max(Collections):根据元素的自然排序，返回给定集合中的最大元素
        System.out.println("最大值= " + Collections.max(list));

        //Object max(Collections, compare):根据 Collections 指定的顺序，返回给定集合中的最大元素
        Object max = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照长度来比较
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("指定排序的最大值= " + max);

        //Object min(Collections):根据元素的自然排序，返回给定集合中的最小元素
        //Object min(Collections, compare):根据 Collections 指定的顺序，返回给定集合中的最小元素
        //最小值，参考最大值方法

        //copy(List dest, List src):将src中的内容复制到dest中
        ArrayList dest = new ArrayList();
        //为了完成一个完整的拷贝，需要先给 dest 赋值 大小和list.size()一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        //拷贝
        Collections.copy(dest, list);
        System.out.println("dest= "+ dest);

        //replaceAll(List list, Object oldVal, Object newVal):使用新值替换 List 对象的所有旧值
        Collections.replaceAll(list, "tm", "汤姆");
        System.out.println("替换后= " + list);

    }
}
