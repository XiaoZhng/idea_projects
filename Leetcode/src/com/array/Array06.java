package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alonso
 */
public class Array06 {
    /**
     * 两个数组的交集 II
     *
     * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
     * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
     * 可以不考虑输出结果的顺序。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null && nums1.length == 0 && nums2 == null && nums2.length == 0){
            return null;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList();
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] > nums2[j]){
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //把list转换为数组
        int[] ints = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            ints[index++] = integer;
        }
        return ints;
    }
}
