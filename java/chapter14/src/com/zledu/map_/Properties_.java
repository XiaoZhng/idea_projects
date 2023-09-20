package com.zledu.map_;

import java.util.Properties;

public class Properties_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //1.properties 继承了 Hashtable
        //2.可以通过 k-v 存放数据，当然key 和 value 不能为 null
        Properties properties = new Properties();
        properties.put("jack", 10);
        properties.put("tom", 20);
        //properties.put(null, 10);//抛出 空指针异常
        //properties.put(10, null);//抛出 空指针异常
        properties.put("tom", 30);//替换 "tom", 30
        properties.put("lucy", 40);

        System.out.println("propertise=" + properties);

        //通过k，获取对应值
        System.out.println(properties.get("tom"));//30

        //删除
        properties.remove("lucy");
        System.out.println(properties);

        //修改
        properties.put("jack", "杰克");
        System.out.println(properties);
    }
}
