package com.zledu.wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer) -> String
        Integer i = 10;
        //方式一
        String str1 = i + "";//自动装箱
        //方式二
        String str2 = String.valueOf(i);
        Integer integer = Integer.valueOf(1);
        //方式三
        String str3 = i.toString();

        //String -> 包装类(Integer)
        String str4 = "123";
        //方式一
        Integer i1 = new Integer(str4);//构造器
        //方式二
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        int i11 = 127;
    }
}
