package com.zledu.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("No1", "jack");
        map.put("No2", "tom");
        //map.put(new car(), new cat());
        System.out.println(map.getClass());//HashMap


        //解读：
        //1. k-v 最后是 HashMap$Node node = newNode(hash, key, value, null);
        //2. k-v 为了方便程序员的遍历，还会 创建 EntrySet 集合，该集合存放的元素的类型是 Entry
        //   而一个Entry 对象就有k,v EntrySet<Entry<k,y>>，即：transient Set<Map.Entry<K,V>> entrySet;

        Set set = map.entrySet();
        System.out.println(set.getClass());//entrySet
        for (Object obj :set) {
            //System.out.println("obj=" + obj.getClass());//HashMap$Node
            //为了从 HashMap$Node 取出 k-v
            //向下转型成 Map.Entry 调用 getKey(); getValue();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        //3. 在EntrySet中，定义的类型是 map.Entry，但是实际上存放的k,v类型还是 HashMap$Node
        //   这是因为 HashMap$Node 实现了 Entry接口. static class Node<K,V> implements Map.Entry<K,V>
        //4. 当把 HashMap$Node 对象 存放到 EntrySet 就方便我们的遍历，因为 Map.Entry 提供了重要方法
        //   K getKey();  V getValue();

        Set set1 = map.keySet();
        System.out.println("set1=" + set1.getClass());//HashMap$KeySet
        Collection values = map.values();
        System.out.println("values=" + values.getClass());//HashMap$Values

    }
}
class car{}
class cat{}