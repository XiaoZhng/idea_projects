package com.zledu.map_;

import java.util.HashMap;
import java.util.Objects;

public class HashMapSource02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //树化演示
        HashMap map = new HashMap();
        for (int i = 1; i <= 12; i++){
            map.put(new A(i), "hello");
        }
        System.out.println(map);
    }
}
class A{
    private int num;

    public A(int num) {
        this.num = num;
    }
    //所有hash值返回100
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}