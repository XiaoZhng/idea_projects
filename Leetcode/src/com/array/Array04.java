package com.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alonso
 */
public class Array04 {
    /**
     * 存在重复元素
     *
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     */
    public static void main(String[] args) {
        int[] ints = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(ints));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);//先排序
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }

        return false;
    }

    public void numQuest(List<Integer> nums) {
        int k = 0;
        Integer zero = new Integer(0);
        while (k < nums.size()) {
            if (nums.get(k).equals(zero))
                nums.remove(k);
            k++;
        }
    }
}
