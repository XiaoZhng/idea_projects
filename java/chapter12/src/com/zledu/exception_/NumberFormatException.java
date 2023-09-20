package com.zledu.exception_;

//数字格式不正确
public class NumberFormatException {
    public static void main(String[] args) {
        String name = "aaa";
        //将String 转成 int
        int num = Integer.parseInt(name);//NumberFormatException 数字格式不正确
        System.out.println(num);
    }
}
