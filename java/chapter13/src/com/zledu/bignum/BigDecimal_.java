package com.zledu.bignum;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {

        //当我们需要保存一个精度很高的数时，我们发现double 不够用
        //可以用 BigDecimal
//        double d = 199.1111111111111111111111111d;
//        System.out.println(d);

        BigDecimal bigDecimal = new BigDecimal("199.11111111111119999999999999111111111111");
        BigDecimal bigDecimal1 = new BigDecimal("3");
        System.out.println(bigDecimal);

        //1.如果对 BigDecimal 进行运算，比如加减乘除，需要使用对应的方法
        //2.创建一个需要操作的 BigDecimal 然后调用相应的方法即可
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
        //System.out.println(bigDecimal.divide(bigDecimal1));//可能抛出异常 ArithmeticException
        //在调用divide方法时，指定精度即可 BigDecimal.ROUND_CEILING
        //如果有无限循环小数，就会保留 分子 的精度(就是保留小数点位数和除数一样，避免无限循环)
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING));
    }
}
