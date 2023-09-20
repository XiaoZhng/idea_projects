package com.zledu.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //1.以Set 接口的实现类 HashSet 来讲解Set 接口的方法
        //2.Set 接口的实现类的对象(Set接口对象)，不能存放重复的元素，可以添加一个null
        //3.Set 接口对象存放数据是无序(即添加的顺序和去除的顺序不一致)
        //4.注意：去除的顺序虽然不是添加的顺序，但它是固定的
        Set set = new HashSet();
        set.add("jack");
        set.add("tom");
        set.add("Sam");
        set.add("jack");//重复
        set.add(null);
        set.add(null);
        System.out.println("set=" + set);

        //遍历
        //方式一：
        System.out.println("迭代器遍历set====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj=" + obj);
        }

        //方式二：
        System.out.println("增强for遍历set====");
        for (Object o :set) {
            System.out.println("o=" + o);
        }

        //Set接口对象不能通过索引获取(不能使用普通for循环)

        set.remove(null);
        System.out.println(set);
    }
}
