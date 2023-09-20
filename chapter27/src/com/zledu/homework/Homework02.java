package com.zledu.homework;

/**
 * @author Alonso
 */
public class Homework02 {
    /**
     * 验证是不是整数或者小数
     * 要考虑正数和负数
     * 比如：123 -456 23.45 -0.01 0.67
     */
    public static void main(String[] args) {

        /**
         * 思路：
         * 1.先写出简单的正则表达式
         * 2.再逐步完善(根据各种情况完善)
         *
         *  ^[-+]?([1-9]\\d*|0)([.]\\d+)?$
         *  [-+]?：  -+号可有可无
         *  ([1-9]\\d*|0)：  小数点左边的数有两种情况：1.第一位数必须是1-9，后面任意数字可有可无 2.固定0开头
         *  ([.]\\d+)?： 小数点右边，小数点固定，后面任意数字必须有一个，整体包括小数点可有可无
         */
        String content = "78";
        String regStr = "^[-+]?([1-9]\\d*|0)([.]\\d+)?$";
        if (content.matches(regStr)){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }
    }
}
