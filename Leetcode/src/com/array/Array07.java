package com.array;

import java.util.Arrays;

/**
 * @author Alonso
 */
public class Array07 {
    /**
     * 加一
     *
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,9};
        System.out.println(Arrays.toString(plusOne(ints)));
    }

    public static int[] plusOne(int[] digits) {
        /**
         * 1.从后往前遍历数组
         * 2.如果数字不等于9，那么直接+1，然后返回数组
         * 3.如果数字等于9，先设为0，然后继续遍历，当有不等于9的数字时，+1，返回数组
         * 4.如果数组都等于9，那么就表示遍历过后数组每一位都为0，那么就数组扩容，把第一位设为1，返回数组
         */
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }
}