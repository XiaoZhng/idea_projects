package com.zledu.object_;

public class HashCode_ {
    public static void main(String[] args) {
        //两个引用，如果指向的是不同对象，则哈希值不一样
        AA aa1 = new AA();
        AA aa2 = new AA();
        System.out.println("aa1.hashCode() = " + aa1.hashCode());
        System.out.println("aa2.hashCode() = " + aa2.hashCode());

        //两个引用，如果指向的是同一个对象，则哈希值一样
        //哈希值主要根据地址号来的，不能完全将哈希值等价于地址
        //haShCode()方法是提高具有哈希结构的容器的效率
        AA aa3 = aa1;
        System.out.println("aa3.hashCode() = " + aa3.hashCode());
    }
}

class AA{}