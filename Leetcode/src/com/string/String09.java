package com.string;


/**
 * @author Alonso
 */
public class String09 {
    /**
     * 最长公共前缀
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    public static void main(String[] args) {
        String[] strings = new String[]{"asd", "asgh", "asrtd"};
        System.out.println(new String09().longestCommonPrefix(strings));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        //假定第一个字符串是公共前缀
        String per = strs[0];
        //设定一个指针 i，指向后一个字符串，让公共前缀与它进行比较
        int i = 1;
        while (i < strs.length){
            //如果后一个字符串中没有公共前缀部分，则返回-1，有返回0
            while (strs[i].indexOf(per) != 0){
                //如果没有公共前缀，就截取公共前缀最后一个字符
                //直到第二个字符串有公共前缀为止
                //这里截取的是公共前缀而不是比较的字符串，因为没有返回0表示没有包含
                //就表示公共前缀不是真正的公共前缀，就要修改公共前缀
                per = per.substring(0, per.length() - 1);
            }
            //第二个字符串有公共前缀的话，就往后一个字符串继续比较，以此类推
            i++;
        }
        //返回公共前缀
        return per;
    }
}
