package com.zledu.bignum;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {

        //当我们编程中，需要处理很大的整数，long 不够用
        //可以使用BigInteger的类来搞定
//        long l = 987834657843549385l;
//        System.out.println("l=" + l);

        BigInteger bigInteger = new BigInteger("765734758437458743");
        BigInteger bigInteger2 = new BigInteger("7657347584676743");
        System.out.println(bigInteger);
        //1.在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
        //2.可以创建一个 要操作的 BigInteger 然后进行相应操作
        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);//加
        BigInteger subtract = bigInteger.subtract(bigInteger2);//减
        System.out.println(subtract);
        BigInteger multiply = bigInteger.multiply(bigInteger2);//乘
        System.out.println(multiply);
        BigInteger divide = bigInteger.divide(bigInteger2);//除
        System.out.println(divide);

    }
}
