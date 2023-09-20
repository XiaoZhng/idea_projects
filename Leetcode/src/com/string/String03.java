package com.string;

/**
 * @author Alonso
 */
public class String03 {
    /**
     * 字符串中的第一个唯一字符
     *
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     */
    public static void main(String[] args) {
        String s = "gasdfasdf";
//        System.out.println(s.length());
//        char[] chars = s.toCharArray();
//        System.out.println(chars.length);
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        /**
         * 1.因为字符串的字符是在 26个字母之间，所以创建长度为26的 int[]
         * 2.把字符串变为char[]
         * 3.遍历 char[]，记录元素出现的次数
         * 4.'a'：根据ASCII值计算，a~z对应97~122，a则为a-a即为0，z则为z-a即为25，a-z之间的也一一对应。
         *   char元素 - 'a' 的结果比在 0-25之间，所以对应 int[]该位置+1
         * 5.再次遍历 char[]，找出 int[]中为 1的元素，表示它对应的 char元素 - ‘a’只出现了一次，
         *   就可以把该数的下标 i返回
         */
        int[] count = new int[26];
        //把字符串变为char[]
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //遍历 char[]，char元素 - a的结果，作为count[]的下标，出现一次就+1
            count[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            //遍历 char[]，如果 count[]中有1的元素，则表示该位置对应的 char[]元素只出现一次，返回下标
            if (count[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
