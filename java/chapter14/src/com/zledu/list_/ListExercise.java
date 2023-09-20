package com.zledu.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        /*
             添加10个以上的元素(比如String "hello") 在2号位插入一个元素，获得第五个元素
             删除第6个元素，修改第七个元素，再使用迭代器遍历集合
         */
        List list = new ArrayList();
        for (int i = 0; i < 10; i++){
            list.add("hello" + i);
            }
        System.out.println(list);
//在2号位插入一个元素
        list.add(2,"hspedu");
        System.out.println(list);
        //获得第五个元素
        System.out.println(list.get(5));//hello4
//删除第6个元素
        list.remove(6);
        System.out.println(list);
//修改第七个元素
        list.set(7, "007");
        System.out.println(list);
        //使用迭代器遍历集合
        System.out.println("使用迭代器-------------");
        Iterator iterator = list.iterator();
//        for (Object obj : list){
//            System.out.println(obj);
//        }
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
