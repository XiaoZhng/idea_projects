package com.string;

/**
 * @author Alonso
 */
public class String05 {
    /**
     * 验证回文串
     *
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xne8id/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new String05().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null){
            return false;
        }

        //把字符串转成小写
        s = s.toLowerCase();
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
