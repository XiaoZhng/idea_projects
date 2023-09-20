package com.zledu.map_;

import java.util.Hashtable;

public class HashTable_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Hashtable table = new Hashtable();
        table.put("jack", 10);//ok
        table.put("lucy", 20);//ok
        //table.put(null, 10);//NullPointerException
        //table.put(20, null);//NullPointerException
        table.put("tom", 30);//ok
        table.put("jack", 30);//替换 "jack", 30
        table.put("tom1", 30);//ok
        table.put("tom2", 30);//ok
        table.put("tom3", 30);//ok
        table.put("tom4", 30);//ok
        table.put("tom5", 30);//ok
        table.put("tom6", 30);//ok
        System.out.println("table= " + table);

        /*
            阅读源码：
            (1) Hashtable table = new Hashtable();
            //第一次设定的table表容量为 11
            public Hashtable() {
                this(11, 0.75f);
            }
            (2) 进入put()
            public synchronized V put(K key, V value) {
                // key 和 value不能为null，否则抛出异常 NullPointerException()
                if (value == null) {
                    throw new NullPointerException();
                }

                // Makes sure the key is not already in the hashtable.
                Entry<?,?> tab[] = table;
                int hash = key.hashCode();//把key对应的hashCode() 赋给 hash
                int index = (hash & 0x7FFFFFFF) % tab.length; //通过运算得到索引值
                @SuppressWarnings("unchecked")
                Entry<K,V> entry = (Entry<K,V>)tab[index];//entry 指向 table表指定的索引位置
                for(; entry != null ; entry = entry.next) { //判断 table表指定的索引位置是否为null
                    if ((entry.hash == hash) && entry.key.equals(key)) {
                        V old = entry.value;
                        entry.value = value;
                        return old;
                    }
                }

                addEntry(hash, key, value, index);//
                return null;
            }
            (3) 进入addEntry() 把k-v通过方法，放入到 table表中
            private void addEntry(int hash, K key, V value, int index) {
                modCount++;

                Entry<?,?> tab[] = table;
                if (count >= threshold) { //如果添加的次数 >= 临界值，则扩容
                    // Rehash the table if the threshold is exceeded
                    rehash(); //扩容方法

                    tab = table;
                    hash = key.hashCode();
                    index = (hash & 0x7FFFFFFF) % tab.length;
                }

                // Creates the new entry.
                @SuppressWarnings("unchecked")
                Entry<K,V> e = (Entry<K,V>) tab[index];
                tab[index] = new Entry<>(hash, key, value, e);
                count++;
            }
            (4) 添加次数 >= threshold 进入rehash()
            protected void rehash() {
                int oldCapacity = table.length; //oldCapacity = 11
                Entry<?,?>[] oldMap = table; // oldMap = 11

                // overflow-conscious code
                int newCapacity = (oldCapacity << 1) + 1; //扩容计算 两倍+1
                if (newCapacity - MAX_ARRAY_SIZE > 0) {
                    if (oldCapacity == MAX_ARRAY_SIZE)
                        // Keep running with MAX_ARRAY_SIZE buckets
                        return;
                    newCapacity = MAX_ARRAY_SIZE;
                }
                Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];

                modCount++;
                threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
                table = newMap;

                for (int i = oldCapacity ; i-- > 0 ;) {
                    for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
                        Entry<K,V> e = old;
                        old = old.next;

                        int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                        e.next = (Entry<K,V>)newMap[index];
                        newMap[index] = e;
                    }
                }
            }

            总结：
            1. 底层有数组 Hashtable$Entry[] 初始化大小为 11
            2. 临界值 threshold(8) = 11 * 0.75
            3. 扩容：按照总结的扩容机制进行 以前容量的两倍+1
            4. 执行方法 addEntry(hash, key, value, index); 添加k-v 封装到Entry
            5. 按照 int newCapacity = (oldCapacity << 1) + 1; 的大小扩容

            HashMap 和 Hashtable 的对比
            HashMap：  版本1.2  线程不安全、效率高、允许null键null值
            Hashtable：版本1.0  线程安全、效率较低、不允许null键null值
         */
    }
}
