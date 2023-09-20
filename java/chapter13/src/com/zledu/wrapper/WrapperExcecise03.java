package com.zledu.wrapper;

public class WrapperExcecise03 {
    public static void main(String[] args) {
        //(1)
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);//f

        //(2)
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);//f

        //(3)
        Integer i5 = 127;//底层 Integer.valueOf(127)
        Integer i6 = 127;//底层 Integer.valueOf(127)
        System.out.println(i5 == i6);//t

        //(4)
        Integer i7 = 128;//底层 Integer.valueOf(128)
        Integer i8 = 128;//底层 Integer.valueOf(128)
        System.out.println(i7 == i8);//f

        //(5)
        Integer i9 = 127;//底层 Integer.valueOf(127)
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);//f

        //(6)
        Integer i11 = 127;//底层 Integer.valueOf(127)
        int i12 = 127;
        System.out.println(i11 == i12);//t
        //只有基本数据类型，判断的是值是否相等
        //(7)
        Integer i13 = 128;//底层 Integer.valueOf(128)
        int i14 = 128;
        System.out.println(i13 == i14);//t
    }
}
