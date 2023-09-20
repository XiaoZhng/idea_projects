package com.zledu.homeworks_;

public class Homeworks03 {
    public static void main(String[] args) {
        /**
         * 完成输出格式要求的字符串
         * 思路分析：
         * (1) 编写方法完成
         * (2) 对字符串进行分割 split(" ") 按照空格分割
         * (3) 把分割好的字符串数组进行格式化 String.format()
         * (4) 改进，对输入的字符串进行校验
         */

        String str = "Long Hao Chen";
        try {
            prineStr(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void prineStr(String str){
        //校验
        if (str == null){
            throw new RuntimeException("字符串不能为空...");
        }

        String[] strName = str.split(" ");
        //判断长度是否符合标准才能进行分割，长度=3
        if (strName.length != 3){
            throw new RuntimeException("字符串格式不正确...");
        }

        //格式化
        //strName[1].toUpperCase().charAt(0)：所在索引的字符串大写，并且输出第一个字符
        String format = String.format("%s,%s .%c", strName[2], strName[0], strName[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
