package com.zledu.enum_.exercise_;

public class Exercise03 {
    public static void main(String[] args) {
        AA boy = AA.boy;
        AA boy2 = AA.boy;
        System.out.println(boy);//本质就是调用父类Enum toString()，看源码Enum的toString()就是返回name
//        public String toString() {
//            return name;
//        }
        System.out.println(boy == boy2);//true
//        Enum
    }
}

enum AA{
    boy, girl;
}