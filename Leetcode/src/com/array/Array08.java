package com.array;

import java.util.Arrays;

/**
 * @author Alonso
 */
public class Array08 {
    /**
     * 移动零
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    public static void main(String[] args) {
        int[] ints = new int[]{0,1,0,3,12};
        //00123 01230 12300
        //10302 13302(2) 13202(3) 13200
        moveZeroes(ints);
    }

    public static void moveZeroes(int[] nums) {
        /**
         * 1.创建一个遍历记录数组中不等于数字的数量
         * 2.遍历数组，当 nums[i]!=0时，就把数字向前移，然后记录到变量中
         * 3.再次遍历数组，初始值为不等于0的个数，就表示前面的遍历把不等于0的数都移到了前面，
         *   剩下的全部设为0
         */
        if (nums == null && nums.length == 0){
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
