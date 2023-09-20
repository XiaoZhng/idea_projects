package com.zledu.map_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //使用默认的构造器，创建TreeMap，是无序的(也没有排序)

        //要求按照传入的k(String) 的大小来排序
        //TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //要求按照传入的k(String) 的大小来排序
                //return ((String)o1).compareTo((String)o2);
                //要求按照k(String) 的长度大小来排序
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("lucys", "露西");
        treeMap.put("sm", "山姆");
        treeMap.put("bb", "111");//添加不了
        treeMap.put("jack", "jack");//替换
        System.out.println("treemap= " + treeMap);

        /*
            阅读源码：
            (1) 构造器，把传入的实现了 Comparator接口的匿名内部类(对象)，传给了TreeMap的 Comparator
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
            (2) 第一次添加，把k-v 封装到 Entry对象，放入root
            Entry<K,V> t = root;
            if (t == null) {
                compare(key, key); // type (and possibly null) check

                root = new Entry<>(key, value, null);
                size = 1;
                modCount++;
                return null;
            }
            (3) 第二次添加
            Comparator<? super K> cpr = comparator;
            if (cpr != null) {
                do { //遍历所有key，给当前key找到适当的位置
                    parent = t;
                    cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的compare
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else //如果遍历过程中，发现准备添加的key和当前已有的key相等，就直接返回，不添加
                        return t.setValue(value);
                } while (t != null);
            }
         */
    }
}
