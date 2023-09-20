package com.zledu.Set_;

import java.util.HashSet;

public class HashSetSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet() ;
        hashSet.add("java");
        hashSet.add("tom");
        hashSet.add("java");

        /*
            阅读源码：
            (1) HashSet hashSet = new HashSet();
            public HashSet() {
                map = new HashMap<>();
            }
            (2) 执行 hashSet.add("java");
            (2.1) 进入add() e=java，PRESENT = private static final Object PRESENT = new Object(); (present)
            public boolean add(E e) {
                return map.put(e, PRESENT)==null;
            }
            (3) 进入put() key = java，value = PRESENT
            (3.1) hash(key) 得到 key 对应的hash值，这个hash值不是hashCode，而是一个算法， 三元运算符返回(h = key.hashCode()) ^ (h >>> 16)
            (3.2) return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            public V put(K ke y,V value) {
                return putVal(hash(key), key, value, false, true);
            }
            (4) 进入putVal()
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i; //定义辅助遍历
                //table 就是 HashMap 的一个数组，类型是 Node[]，第一次进来为null，长度为0
                //if 语句表示如果当前table 是null，或者 大小=0
                //就是第一次扩容，到16个空间
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length; //执行 resize()，返回newTab=16,赋给n
                //(1)根据 key，得到的hash值，去计算该key应该存放到table 表的哪个索引位置
                //并且把这个位置的对象 赋给 p
                //(2) 再判断 p是否为null，如果p为null，表示还没有存放元素，就创建一个Node(key="java"，value=PRESENT)，
                //就放在该位置 tab[i] = newNode(hash, key, value, null);
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                //开发技巧提示：在需要局部变量(辅助变量)的时候，再创建
                    Node<K,V> e; K k;
         //如果当前索引位置对应的链表的第一个元素 和 准备添加的key的hash值是一样 && p指向的Node结点的key 和 准备加入的key是同一对象
         //准备加入的key不等于null && 准备加入的key的 equals() 和 p指向Node结点的key相同
         //就不能加入(满足两个条件之一)
                    if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
         // 再判断 p 是不是 一颗红黑树，如果是红黑树，就调用 putTreeVal()，来进行添加
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
         // 如果他变了对应索引位置，已经是一个链表，就使用for循环比较
         // (1)依次和链表的每一个元素比较后，都不相同，则加入到该链表的最后
         // 注意在吧元素添加到链表后，立即判断 该链表是否已经达到8个结点，就调用 treeifyBin() 对当前这个链表进行树化(转成红黑树)
         // 注意，在转成红黑树时，又再进行判断
             if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY(64))
                resize();
         // 如果上面条件成立，先 table扩容
         // 只有上面条件不成立，才进行转成红黑树
         // (2)依次和链表的每一个元素比较后，有相同的情况，则直接break
                    else {
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD(8) - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold) //判断table数组的大小是否大于 threshold(12)，threshold是resize()中的设置的临界值
                    resize();
                afterNodeInsertion(evict);
                return null;
            }
         */
    }
}
