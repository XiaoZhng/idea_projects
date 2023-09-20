package com.zledu.Set_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //1.当我们使用无参构造器，创建TreeSet时，仍然是无序的
        //2.使用TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)，并指定排序规则

        //TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 调用String的 compareTo方法进行字符串大小比较
                //return ((String)o1).compareTo((String)o2);
                //按长度来排序比较
                return ((String)o2).length() - ((String)o1).length();
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("a");
        treeSet.add("bc");

        System.out.println(treeSet);

        /*
            阅读源码：
            (1) 构造器把传入的比较器对象，赋给了 TreeSet的底层的 TreeMap的属性 this.comparator
            public TreeSet(Comparator<? super E> comparator) {
                this(new TreeMap<>(comparator));
            }
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
            (2) 在调用 TreeSet.add("tom")，底层会执行到
            if (cpr != null) { //cpr 就是我们的匿名内部类(对象)
                do {
                    parent = t;
                    //动态绑定到我们的匿名内部类(对象)compare
                    cmp = cpr.compare(key, t.key);
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else //如果相等，即返回0，这个key就没有加入
                        return t.setValue(value);
                } while (t != null);
            }
         */
    }
}
