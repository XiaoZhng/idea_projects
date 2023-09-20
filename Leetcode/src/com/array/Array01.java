package com.array;

public class Array01 {
    /**
     * 删除排序数组中的重复项
     *
     给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

     由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。

     将最终结果插入nums 的前 k 个位置后返回 k 。

     不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

     作者：力扣 (LeetCode)
     链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,5,6,6};//1,2,3,4,5,6
//        {1,1,2,3,3,4,5,6,6}
//        {1,2,1,3,3,4,5,6,6}
//        {1,2,3,1,3,4,5,6,6}
//        {1,2,3,1,3,4,5,6,6}
//        {1,2,3,4,5,6,1,3,6} index=5 length=6
        /**
         * 思路分析：
         * 1.遍历数组
         * 2.设置两个辅助变量，i=0,j=1
         * 3.第一个数和第二个数比较，当第一个数和第二数相同时，则i不变，j+1，和后面一个数比较，直到比到最后一个数，要是没有相同的，则返回数组
         * 4.第一个数和第二个数比较，当第一个数和第二数不相同时，则把 j放到 (i+1)，然后i+1，j+1，接着比较
         */

        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums){
        //校验数组
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}
