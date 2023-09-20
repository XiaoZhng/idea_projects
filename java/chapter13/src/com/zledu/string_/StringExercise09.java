package com.zledu.string_;

public class StringExercise09 {
    public static void main(String[] args) {
        String s1 = "jack";//指向池中的 "jack"
        String s2 = "java";//指向池中的 "java"
        String s5 = "jackjava";//指向池中的 "jackjava"
        String s6 = (s1 + s2).intern();//因为intern()是返回常量池地址，所以返回前面的(s1+s2)在池中的地址 "jackjava"
        System.out.println(s5 == s6);//t
        System.out.println(s5.equals(s6));//t
    }
}
