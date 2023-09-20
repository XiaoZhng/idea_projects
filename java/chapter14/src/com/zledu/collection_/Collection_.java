package com.zledu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Collection_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //解读：
        /**
         * 1.集合主要是两组(单列集合、双列集合)
         * 2.Collection 接口有两个重要的子接口 List Set，他们的实现子类都是单列集合(单个元素)
         * 3.Map 接口的实现子类 是双列集合，存放的是 K-V
         * 4.把两张图记下来
         */
        //Collection
        //Map

        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");
        System.out.println(arrayList);

        HashMap hashMap = new HashMap();
        hashMap.put("001", "北京");
        hashMap.put("002", "深圳");
        System.out.println(hashMap);

    }
}
