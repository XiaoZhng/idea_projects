package com.zledu.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Alonso
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        //创建 PrivateTest类
        Class<?> aClass = Class.forName("com.zledu.homework.PrivateTest");
        //也可以使用此方法创建Class对象
        //Class<PrivateTest> privateTestClass = PrivateTest.class;
        Object o = aClass.newInstance();
        //利用Class类得到name属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        //System.out.println(name.get(o));//helloKitty
        //修改name属性值，并调用getName()输出
        name.set(o, "jack");
        Method getName = aClass.getDeclaredMethod("getName");
        //因为getName是public的，所以不用爆破，可直接调用
        System.out.println(getName.invoke(o));//jack
    }
}

class PrivateTest{
    private String name = "helloKitty";

    public String getName() {
        return name;
    }
}