package com.zledu.list_;

import java.util.*;

public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //List 接口的实现子类 Vector LinkedList
        //List list = new ArrayList();
        //List list = new Vector();
        List list = new LinkedList();

        list.add("a11");
        list.add("a22");
        list.add("a33");
        list.add("a44");
        list.add("a55");

        //1.迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }

        System.out.println("==============");
        //2.增强for
        for (Object o :list) {
            System.out.println(o);
        }

        System.out.println("==============");
        //3.普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
