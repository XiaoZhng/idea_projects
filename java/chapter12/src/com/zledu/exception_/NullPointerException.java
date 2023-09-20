package com.zledu.exception_;

//空指针异常
public class NullPointerException{
    public static void main(String[] args) {
        //String num = "123";
        String num = null;//NullPointerException 空指针异常
        System.out.println(num.length());
    }
}
