package com.zledu.list_;

import java.util.Vector;

public class Vector_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //Vector：如果是无参，默认容量10，满后，按2倍扩容
        //        如果是有参按指定大小，满后，则按按2倍扩容

        //无参构造器
        Vector vector = new Vector();
        /*
            (1) 调用无参构造器，看源码，直接把空间设为 10
                public Vector() {
                    this(10);
                }

                public Vector(int initialCapacity) {
                    this(initialCapacity, 0);
                }
            (2) ensureCapacityHelper() 判断是否要扩容
                public synchronized boolean add(E e) {
                    modCount++; //集合被修改的次数
                    //elementCount=0，可以把elementCount理解成集合中数据的个数，第一次集合中没数据，所以为0
                    ensureCapacityHelper(elementCount + 1);
                    elementData[elementCount++] = e;
                    return true;
                }
            (3) 如果 minCapacity(1) - elementData.length(10) > 0 ,则进入grow()，进行扩容，否则不扩容
            private void ensureCapacityHelper(int minCapacity) {
                // overflow-conscious code
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
            }
            (4) 不进行扩容后，返回到 add()，把e(1) 赋给 集合中下标0的位置
            elementData[elementCount++] = e;
            (5) 当容量不够时需要扩容，满足ensureCapacityHelper() 的if判断后进入grow()
            private void grow(int minCapacity) {
                // overflow-conscious code
                int oldCapacity = elementData.length; //创建一个变量存放集合的长度
                //capacityIncrement初值是0，所以 (capacityIncrement > 0)为假时，oldCapacity + oldCapacity(2倍扩容)
                int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                                 capacityIncrement : oldCapacity);
                if (newCapacity - minCapacity < 0)
                    newCapacity = minCapacity;
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
         */
        for (int i = 1; i <= 10; i++){
            vector.add(i);
        }
        vector.add(100);
    }
}
