package com.zledu.exception_;

//数字运算异常
public class AirthmeticException {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;
        int res = n1 / n2;
        System.out.println(res);//ArithmeticException 数字运算异常
    }
}
