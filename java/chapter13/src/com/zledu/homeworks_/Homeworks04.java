package com.zledu.homeworks_;

public class Homeworks04 {
    public static void main(String[] args) {
        /**
         * 输入字符串，判断有多少个大写字母、小写字母、数字
         * 思路分析
         * (1) 编写方法，完成功能
         * (2) 把字符串转换成char[] toCharArray()
         * (3) 遍历char[]，定义辅助变量，在循环语句中判断：通过阿斯克码判断
         */
        String str = "34gFD";
        try {
            letter(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void letter(String str){
        //校验
        if (str == null){
            throw new RuntimeException("字符串不能为null...");
        }

        //String 转换char[]
        char[] chars = str.toCharArray();

        //定义辅助变量
        int capital = 0;//大写字母数量
        int Lowercase = 0;//小写字母数量
        int number = 0;//数字数量

        //遍历 char[]
        for (int i = 0; i < chars.length; i++){
            //判断大写
            if (chars[i] >= 'A' && chars[i] <= 'Z'){
                capital++;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                Lowercase++;
            }
            if (chars[i] >= '0' && chars[i] <= '9'){
                number++;
            }
        }
        System.out.println("大写字母=" + capital + " 小写字母=" + Lowercase + " 数字=" + number);
    }
}
/*
f t t  f f t
 */