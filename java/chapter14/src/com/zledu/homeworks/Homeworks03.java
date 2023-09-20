package com.zledu.homeworks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Homeworks03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);

        //将Jack工资改为2600
        m.put("jack", 2600);
        System.out.println(m);

        //为所有员工工资+100
        //先获取到员工的工资
        Set keyset = m.keySet();
        for (Object key :keyset) {
            //相当于是更新员工工资    int类型在put()后会自动装箱成Integer
            m.put(key, (Integer)m.get(key)+100);
        }
        System.out.println(m);

        //遍历所有员工
        for (Object key :keyset) {
            System.out.println(key);
        }

        //遍历所有工资
        Set entryset = m.entrySet();
        Iterator iterator = entryset.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            System.out.println(entry.getValue());
        }

    }
}
