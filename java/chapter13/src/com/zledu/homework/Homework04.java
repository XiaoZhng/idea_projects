package com.zledu.homework;

public class Homework04 {
    public static void main(String[] args) {
        String str = "09AZaz";
        check(str);
    }
    public static void check(String str){
        if (str == null){
            System.out.println("str不能为空...");
        }
        char[] chars = str.toCharArray();
        int num = 0;
        int big = 0;
        int sm = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9'){
                num++;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z'){
                big++;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                sm++;
            }
        }
        System.out.println("大写字母：" + big + " 小写字母：" + sm + " 数字：" + num);
    }

    /**
     * 输入字符串，判断有多少个大写字母，小写字母，数字
     *
     * 思路分析
     *
     *  (1) 先把String 转换成char[]
     *  (2) 再进行for循环，逐一判断，判断条件是利用 Ascll码
     */
}