package com.string;

/**
 * @author Alonso
 */
public class String07 {
    /**
     * 实现 strStr()
     *
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果needle 不是 haystack 的一部分，则返回 -1 。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnr003/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static boolean Paddy;
    public static void main(String[] args) {
        System.out.println(Paddy);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
            return -1;
        }

        //设置双指针
        int i = 0;
        int j = 0;
        //逐一循环
        while (i < haystack.length() && j < needle.length()){
            //如果
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }

            if (j == needle.length()){
                return i - j;
            }
        }
        return -1;
    }
}
