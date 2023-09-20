package com.zledu.stringbuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {
        //构造器使用
        //1.创建一个大小为 16的 char[]，用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2.通过构造器指定char[]大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        //3.通过 给一个String 创建 StringBuffer，char[] 大小就是 String.length() + 16
        StringBuffer hello = new StringBuffer("hello");
    }
}
