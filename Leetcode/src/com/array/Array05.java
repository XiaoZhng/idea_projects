package com.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alonso
 */
public class Array05 {
    /**
     * 只出现一次的数字
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static void main(String[] args) {
        int[] ints = new int[]{2,2,1};
        System.out.println(singleNumber(ints));
    }

    public static int singleNumber(int[] nums) {
        if (nums == null && nums.length == 0){
            return 0;
        }
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i+=2) {
//            if (nums[i] != nums[i+1]){
//                return nums[i-1];
//            }
//        }
//        return nums[len(nums)-1];

        Set set = new HashSet();
        for (int num : nums) {
            if (!set.add(num)){
                set.remove(num);
            }
        }
        return (int)set.toArray()[0];
    }
}
