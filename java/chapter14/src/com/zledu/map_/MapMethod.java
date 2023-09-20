package com.zledu.map_;

import java.util.HashMap;

public class MapMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("No1", "jack");//ok
        map.put("No2", "tom");//ok
        map.put("No3", "lucy");//ok
        map.put("No1", "lucy");//替换 "No1", "lucy"
        map.put(null, "lucy");//ok
        System.out.println("map= " + map);

//        remove:根据键删除映射关系
        map.remove("No2");
        System.out.println("map= " + map);

//        get:根据键获取值
        System.out.println(map.get("No1"));//"lucy"

//        size:获取元素个数
        System.out.println(map.size());//3

//        isEmpty:判断个数是否为0
        System.out.println(map.isEmpty());//false

//        clear:清除k-v
        //map.clear();
        System.out.println("map= " + map);//{}

//        containsKey:查找键是否存在
        System.out.println(map.containsKey(null));//true

    }
}
