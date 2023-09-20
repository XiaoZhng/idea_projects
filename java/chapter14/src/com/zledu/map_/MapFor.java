package com.zledu.map_;

import java.util.*;

public class MapFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("No1", "jack");//ok
        map.put("No2", "tom");//ok
        map.put("No3", "lucy");//ok
        map.put("No1", "lucy");//替换 "No1", "lucy"
        map.put(null, "lucy");//ok
        System.out.println("map= " + map);

        //第一组： 先取出所有的key，通过key 取出对应的value
        Set keyset = map.keySet();
        //(1) 增强for
        System.out.println("-----第1种方式：增强for-----");
        for (Object key :keyset) {
            System.out.println(key + "-" + map.get(key));
        }

        //迭代器
        System.out.println("-----第2种方式：迭代器-----");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组：把所有的value 取出
        Collection values = map.values();
        //(1) 增强for
        System.out.println("-----取出所有 value：增强for-----");
        for (Object value :values) {
            System.out.println(value);//反向取，所以没有key
        }

        System.out.println("-----取出所有 value：迭代器-----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object next =  iterator2.next();
            System.out.println(next);
        }

        //第3组：通过 EntrySet 来获取k-v
        Set entryset = map.entrySet();// EntrySet<Entry<k,v>>
        //增强for
        System.out.println("-----通过 EntrySet 来获取k-v：增强for-----");
        for (Object obj :entryset) {
            //将entry 转成 map.entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        //迭代器
        System.out.println("-----通过 EntrySet 来获取k-v：迭代器-----");
        Iterator iterator3 = entryset.iterator();
        while (iterator3.hasNext()){
            Object obj = iterator3.next();
            Map.Entry entry = (Map.Entry) obj;
            //System.out.println(entry.getClass());//HashMap$Node 实现 -> Map.Entry(getKey,getValue)
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


    }
}
