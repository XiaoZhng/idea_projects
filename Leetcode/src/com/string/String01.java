package com.string;


import java.util.Arrays;

/**
 * @author Alonso
 */
public class String01 {
    /**
     * 反转字符串
     *
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new String01().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }

        int i = 0;
        int j = s.length -1;
        while (i < j){
            reverse(s, i++, j--);
        }

    }

    public void reverse(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
