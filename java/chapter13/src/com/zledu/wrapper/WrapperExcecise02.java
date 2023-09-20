package com.zledu.wrapper;

public class WrapperExcecise02 {
    public static void main(String[] args) {
        //(1)
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false
        //new两个对象，== 判断是不是同一对象，所以false

        //(2)
        Integer n = 1;//底层 Integer.valueOf(1)
        Integer m = 1;//底层 Integer.valueOf(1)
        System.out.println(n == m);//true
        /**
         * Integer.valueOf()源码：
         * 解读：
         * 1.如果i 在 IntegerCache.low(-128) ~ IntegerCache.high(127) 就直接从数组返回
         * 2.如果不在 -128~127，就直接 new Integer(i)
         * public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         *     这题需要阅读源码，发现方法中判断实参范围 在 -128 ~ 127之间就直接返回，否则 new一个新的Integer对象
         */

        //(3)
        Integer x = 128;//底层 Integer.valueOf(128)
        Integer y = 128;//底层 Integer.valueOf(128)
        System.out.println(x == y);//false;
        //查看Integer.valueOf()源码，128 超过 -128 ~ 127范围，所以就new个新的Integer对象，输出false

    }
}