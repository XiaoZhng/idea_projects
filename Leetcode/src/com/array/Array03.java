package com.array;

import java.util.Arrays;

/**
 * @author Alonso
 */
public class Array03 {
    /**
     * 旋转数组
     *
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     */
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7};
        rotate(ints, 3);
    }

    public static void rotate(int[] nums, int k) {
        /**
         * 1.旋转数组，就是让(i+1) = i，数组首位的数 = 数组末尾的数
         * 2.while循环控制旋转的次数
         * 3.创建一个临时数组，长度等于 nums[]的长度
         * 4.循环 nums[]，把数组中的数字取出来，把 nums[i]的数，存入临时数组[i+1]的位置，
         *   把 nums[nums.length -1]的数，存入临时数组[0]的位置
         * *5.这是临时数组就是旋转过的数组了，然后赋值给 nums[]，让 nums[]也成为旋转后的
         *    这样下一次旋转就是在第一次旋转后的基础上 再旋转，要是不赋值给 nums[]，
         *    则下一次旋转还是在原始位置中进行旋转，不管旋转几次，结果都是旋转一次
         */
        if (nums == null || nums.length == 0){
            return;
        }

        int[] array = new int[nums.length];
        array = nums;
        int t = 0;
        while (t < k){//2
            int[] ints = new int[nums.length];
            for (int j = 0; j < array.length - 1; j++) {
                ints[j+1] = array[j];
                ints[0] = array[array.length-1];
            }
            array = ints;
            t++;
        }
        System.out.println(Arrays.toString(array));
    }
}
