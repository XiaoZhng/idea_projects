package com.zledu.Set_;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //LinkedHashSet 底层机制
        Set linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("asd");
        linkedHashSet.add(123);
        linkedHashSet.add(new Cat("jack", 10));
        linkedHashSet.add(123);

        System.out.println("LinkedHashSet=" + linkedHashSet);

        /*
            (1) LinkedHashSet 加入顺序和取出元素/数据的顺序一致
            (2) LinkedHashSet 底层维护的是一个LinkedHashMap(是 HashMap的子类)
            (3) LinkedHashSet 底层结构 (数组table+双向链表)
            (4) 添加第一次时，直接将 数组table 扩容到16，存放的结点类型是 LinkedHashMap$Entry
            (5) 数组是 HashMap$Node[] 存放的元素/数据是 LinkedHashMap$Entry类型

            //继承关系是在内部类完成的
            static class Entry<K,V> extends HashMap.Node<K,V> {
                Entry<K,V> before, after;
                Entry(int hash, K key, V value, Node<K,V> next) {
                    super(hash, key, value, next);
                }
            }
         */
    }
}
class Cat{
    private String name;
    private int num;
    public Cat(String name, int num){
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}