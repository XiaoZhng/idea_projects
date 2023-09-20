package com.zledu.string_;

public class StringExercise08 {
    public static void main(String[] args) {

        String a = "hello";//创建了a对象
        String b = "abc";//创建了b对象
        /**
         * 解读：
         * 1.先 创建一个 StringBuilder sb = StringBuilder()
         * 2.执行 sb.append("hello");
         * 3.再执行 sb.append("abc");
         * 4.String c = sb.toString()
         * 最后其实是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
         *
         * 小结：底层是 StringBuilder sb = new StringBuilder(); sb.append(a)
         * sb.append(b); sb在堆中，并且append是在原来字符串的基础上追加的
         * 重要规则：String c1 = "ab" + "cd"; 常量相加，看的是池
         *         String c1 = a + b; 变量相加，是在堆中
         */
        String c = a + b;//指向堆
        String d = "helloabc";//指向池
        System.out.println(c == d);//false
        String e = "hello" + "abc";//指向池 直接看池地址
        System.out.println(e == d);//true
    }
}
