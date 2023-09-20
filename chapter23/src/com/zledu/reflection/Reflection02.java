package com.zledu.reflection;

import com.zledu.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Alonso
 * 测试反射调用的性能和优化方案
 */
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {

        m1();
        m2();
        m3();
    }

    public static void m1() {
        //传统方法调用hi
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法使用的时间=" + (end - start));

    }

    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        //反射机制调用hi
        Class<?> aClass = Class.forName("com.zledu.Cat");
        Object o = aClass.newInstance();
        Method method = aClass.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制使用的时间=" + (end - start));

    }

    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
        //反射调用优化
        Class<?> aClass = Class.forName("com.zledu.Cat");
        Object o = aClass.newInstance();
        Method method = aClass.getMethod("hi");
        method.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制优化使用的时间=" + (end - start));
    }
}
