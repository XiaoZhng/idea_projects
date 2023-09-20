package com.zledu.debug_;

public class Debug01 {
    public static void main(String[] args) {
        //演示逐步执行代码 F8
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += i;
            System.out.println("i= " + i);
            System.out.println("sum= " + sum);
        }
        System.out.println("for结束---");
    }
}
