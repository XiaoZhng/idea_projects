package com.zledu.list_;

import java.util.ArrayList;

public class ArrayListSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //ArrayList：如果是无参，第一次容量10，满后，则按1.5倍扩容
        //          如果是有参按指定大小，满后，则按按1.5倍扩容

        //使用无参构造器创建对象
        //ArrayList arrayList = new ArrayList();
        ArrayList arrayList = new ArrayList();

        /*
            ArrayList arrayList = new ArrayList();
            底层：
            (1) 调用无参构造器，生成一个 {}
            public ArrayList() {
                this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
            }

            private static final Object[] DEFAU LTCAPACITY_EMPTY_ELEMENTDATA = {};

         */
        for (int i = 1; i <= 10; i++){
            arrayList.add(i);
        }
        /*
            add()扩容底层：
            (1) 把int转换成Integer
            public static Integer valueOf(int i) {
                if (i >= IntegerCache.low && i <= IntegerCache.high)
                    return IntegerCache.cache[i + (-IntegerCache.low)];
                return new Integer(i);
            }
            (2) 执行list.add()，先判断是否要扩容，再执行 赋值操作
            public boolean add(E e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
            (3) 1.先确定 elementData 是否为第一次添加(即空数组{})，如果是第一次添加则把
             Math.max(DEFAULT_CAPACITY, minCapacity) 两个数中的最大值赋给 minCapacity，
             这时minCapacity=10;(第一次扩容空间10)。
             2. ensureExplicitCapacity(minCapacity) 调用ensureExplicitCapacity() 是确定是不是真的要扩容

            private void ensureCapacityInternal(int minCapacity) {
                if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                    minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
                }
                ensureExplicitCapacity(minCapacity);
            }
            (4)
            1. 进去ensureExplicitCapacity()   modCount++;是记录集合被修改的次数
            2. 再进行判断，如果 minCapacity(10) - elementData.length(集合的长度,0) > 0，则调用grow()完成扩容
            private void ensureExplicitCapacity(int minCapacity) {
                modCount++;

                // overflow-conscious code
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
            }
            (5)
            private void grow(int minCapacity) { minCapacity=10

                int oldCapacity = elementData.length; 1. 首先先定义一个变量(oldCapacity)来存放集合的长度，oldCapacity =0
                int newCapacity = oldCapacity + (oldCapacity >> 1); 2.接着再定义一个变量(newCapacity)存放 新的容量 newCapacity =0
                if (newCapacity - minCapacity < 0) 3.然后判断 新的容量(0) - 最小的容量(10) < 0，进入if语句，把最小的容量 赋给 新的容量 newCapacity=10
                    newCapacity = minCapacity;
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);

                elementData = Arrays.copyOf(elementData, newCapacity); 4.最后就用 copyOf() 把 elementData从{} 扩容到 10
            }
            (6)
            grow()方法调用完成后就一步步返回，回到 add() 中的 elementData[size++] = e; 这时elementData=10
            就把 e=1赋给 size下标为0的位置
         */

        for (int i = 11; i <= 15; i++){
            arrayList.add(i);
        }

        arrayList.add(100);
        arrayList.add(200);
    }
}
