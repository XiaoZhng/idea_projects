package com.string;

/**
 * @author Alonso
 */
public class String04 {
    /**
     * 有效的字母异位词
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn96us/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(new String04().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];
        //统计 s的中每个字母的个数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        //统计 t中每个字母的个数，然后减去 s的中每个字母的个数
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        //遍历 count[]，如果每个位置都是0，则表示 s和t 互为字母异位词
        for (int i : count) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }

}