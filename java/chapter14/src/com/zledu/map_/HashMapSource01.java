package com.zledu.map_;

import java.util.HashMap;

    public class HashMapSource01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);//ok
        map.put("php", 10);//ok
        map.put("java", 20);//替换 "java", 20
        System.out.println(map);

        /*
            阅读源码：
            (1) HashMap map = new HashMap(); 调用HashMap的无参构造器，初始化加载因子，此时 table = null
            public HashMap() {
                this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
            }
            (2) 首先 自动装箱，转成Integer，进入put()
            //hash() 对应的算法 (h = key.hashCode()) ^ (h >>> 16)
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
            (3) 进入putVal()
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i; //辅助变量
                //判断 table表是否等于null，或者长度是否等于0
                if ((tab = table) == null || (n = tab.length) == 0)
                //第一次 table=null，所以进入判断，进入resize()扩容
                //resize()中定义了第一次的容量(16)，以及临界值(12)，然后就创建一个Node[16]，并放入table中
                // Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap]; table = newTab;
                    n = (tab = resize()).length; //n = 16
                //取出 hash值对应的table的索引位置位置的Node，如果为null，就直接把加入的k-v，创建成一个Node，加入该位置
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k; //辅助变量
                //p指向的key的hash值和新加入的hash值一样 && (p指向的key的内容和新加入的key一样 || equals返回真)
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        // e 指向 p的指向
                        e = p;
                    else if (p instanceof TreeNode) //判断p指向的Node是否是红黑树，如果是，就按照红黑树的方法执行
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                    //如果table表有链表形式，则for循环一个个比较
                        for (int binCount = 0; ; ++binCount) { // 死循环
                        // 如果一个个比较后没有相同的，就在链表的后面把新加入的k-v，创建成一个newNode，放在后面
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                //如果链表的长度 >= 8，则进行树化(红黑树) treeifyBin()
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    //e的指向不等于 null，就把e指向的table表中的value值赋给 oldValue
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                    //e指向的table表中的value，替换成新加入的value
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold) //table表中的元素是否到达临界值，如果到了，就扩容(2倍)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }
            (4) 树化的条件
            链表长度 >= 8 并且 table表的长度 > 64，才进行树化，否则继续扩容resize();
            if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                    resize();
         */
    }
}
