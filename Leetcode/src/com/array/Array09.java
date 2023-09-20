package com.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Alonso
 */
public class Array09 {
    /**
     * 两数之和
     *
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2jrse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] ints = new int[]{3,2,3};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(ints, target)));

        HashMap hashMap = new HashMap();
        hashMap.put(1, 11);
        hashMap.put(2, 22);
        hashMap.put(3, 33);
        System.out.println(hashMap.get(1));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null && nums.length == 0){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //判断 和-遍历数字的差值是否在map中，在就表明有数，直接创建新数组赋值
            if (map.get(target - nums[i]) != null){
                return new int[]{map.get(target-nums[i]), i};
            }
            //和-遍历数字的差值不在map中，就存入map，key=遍历到的数字 value=下标i
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
