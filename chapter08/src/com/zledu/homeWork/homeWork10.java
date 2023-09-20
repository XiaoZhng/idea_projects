package com.zledu.homeWork;

public class homeWork10 {
    public static void main(String[] args) {
//        String str1 = new String("he");
//        String str2 = new String("he");
//        System.out.println(str1 == str2);//f
//        System.out.println(str1.equals(str2));//t
//
//        Doctor l1 = new Doctor("ll",10, "aa", "nan", 1.1);
//        Doctor l2 = new Doctor("ll",10, "aa", "nan", 1.1);
//        System.out.println(l1 == l2);//f
//        System.out.println(l1.equals(l2));//f Doctor类没有重写，所以默认判断地址是否相等

        Doctor d1 = new Doctor("jack", 18, "bos", "男", 100000);
        Doctor d2 = new Doctor("jack", 18, "bos", "男", 100000);
        System.out.println(d1.equals(d2));
    }
}
