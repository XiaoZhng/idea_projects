package com.zledu.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Homework03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("jack", 650);//存入的是int，底层会自动装箱成 Integer
        map.put("tom", 1200);
        map.put("smith", 2900);
        System.out.println("map= "+ map);

        //将jack的工资改为2600
        map.get("jack");
        System.out.println(map);

        //为所有员工+100元
        Set keyset = map.keySet();
//        for (Object key :keyset) {
//            map.put(key, (Integer)map.get(key) + 100);
//        }
        Set set = map.entrySet();
        for (Object o :set) {
            Map.Entry entry = (Map.Entry)o;
            map.put(entry.getKey(), (Integer)entry.getValue() + 100);
        }

        System.out.println("entryset+100= " + map);

        //遍历所有的员工
        System.out.println("========遍历所有的员工");
        for (Object key :keyset) {
            System.out.println(key);
        }

        //遍历所有的工资
        System.out.println("遍历所有的工资==========");
        Set entry = map.entrySet();
        Iterator iterator = entry.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            Map.Entry value = (Map.Entry)obj;
            System.out.println(value.getValue());
        }
        System.out.println("增强for=============");
        for (Object obj :entry) {
            Map.Entry values = (Map.Entry)obj;
            System.out.println(values.getValue());
        }


    }
}
