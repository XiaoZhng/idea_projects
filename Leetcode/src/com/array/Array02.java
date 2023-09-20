package com.array;

/**
 * @author Alonso
 */
public class Array02 {

    /**
     * 买卖股票的最佳时机 II
     *
     * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] ints = {7,6,4,3,1};
        System.out.println(maxProfit(ints));
    }

    public static int maxProfit(int[] prices) {
        /**
         * 1.利润：对数组中的数进行大小判断，如果最小的数不在最后，则有利润，否则无利润
         * 2.有利润情况一：找到最小数然后再找到最大数，如果最小数在最大数前面，则利润=大-小，
         *   剩下的数再进行一边判断，则利润=大-小，最后总利润=利润1 + 利润2
         * 3.有利润情况二：如果最小数在首位，最大数在末尾，则总利润=大-小
         * 4.无利润情况：最小数在末尾，则无利润，返回0
         *
         * 看题解后思路：
         * 股票利润都是后面卖的价格比前面买的价格高，则表示有利润，所以让排在后面的数-前一个的数是正数就代表有利润
         * 遍历数组，循环条件必须是 i<数组长度，因为有个(i+1)所以会造成数组越界异常
         * 如果 (i+1)的数 - (i)的数 > 0，则就代表有利润，否则无利润
         */
        //校验数组
        if (prices == null || prices.length == 0){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if ((prices[i+1] - prices[i]) > 0){
                max += (prices[i+1] - prices[i]);
            }
        }
        return max;
    }
}
