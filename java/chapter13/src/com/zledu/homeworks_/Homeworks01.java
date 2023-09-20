package com.zledu.homeworks_;

public class Homeworks01 {
    public static void main(String[] args) {
        //将字符串中指定部分进行反转
        String str = "abcdef";
        String reverse = null;
        try {
            reverse = reverse(str, 0, 5);
            System.out.println("交换前=" + str);
            System.out.println("交换后=" + reverse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param str 字符串
     * @param start 字符串指定部分的开头
     * @param end 字符串指定部分的结尾
     * @return
     *
     * 1.把 String转成 char[]，因为String 是 final类 toCharArray()
     * 2.使用for循环把 start 和 end 交换
     */
    public static String reverse(String str, int start, int end){
        //进行校验
        if (!(str != null && start < end && end < str.length())){
            throw new RuntimeException("参数不正确...");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';//辅助变量
        for (int i = start, j = end; i < j; i++, j--){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
