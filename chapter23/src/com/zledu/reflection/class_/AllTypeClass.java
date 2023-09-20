package com.zledu.reflection.class_;

import java.io.Serializable;
import java.lang.Thread.State;

/**
 * @author Alonso
 * 演示哪些类型有Class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Runnable> cls3 = Runnable.class;//接口
        Class<int[][]> cls4 = int[][].class;//二维数组
        Class<Deprecated> cls5 = Deprecated.class;//注解

        Class<Enum> cls6 = Enum.class;//枚举
        Class<State> cls7 = State.class;//枚举
        Class<Long> cls8 = long.class;//基本数据类型
        Class<Void> cls9 = void.class;//void数据类型
        Class<Class> cls10 = Class.class;

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
        System.out.println(cls10);

    }
}
