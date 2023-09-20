package com.zledu.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        //add(int index, Object ele):在index 位置插入ele元素
        list.add(1,"jams");
        System.out.println(list);
        //addAll(int index, Collection ele):在index位置开始将ele中的所有元素添加
        List list2 = new ArrayList();
        list2.add("marry");
        list2.add("kk");
        list.addAll(1, list2);
        System.out.println(list);
        //get(int index):获取去指定index位置的元素
        System.out.println(list.get(2));//kk
        //indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("jams"));//3
        //lastindexOf(Objext obj):返回obj在集合中末次出现的位置
        list.add("jack");
        System.out.println(list);
        System.out.println(list.lastIndexOf("jack"));//5
        //remove(int index):移除指定index位置的元素，返回此元素
        list.remove(1);//marry
        System.out.println(list);
        //set(int index, Object ele):设置指定index位置的元素为ele，相当于替换
        list.set(1, "玛丽");
        System.out.println(list);
        //subList(int fromIndex, int toIndex):返回从 fromIndex 到 toIndex位置的子集合
        //注意返回的子集合 fromIndex <= subList < toIndex (前闭后开，不包含最后一个)
        List returnList = list.subList(0, 2);
        System.out.println("returnList= "+ returnList);//jack, 玛丽
    }
}
