package com.zledu.reflection;

import java.lang.reflect.Field;

/**
 * @author Alonso
 * 演示反射操作属性
 */
public class ReflectionAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        //1.得到student类对应的Class对象
        Class<?> stuClass = Class.forName("com.zledu.reflection.student");
        //2.创建对象
        Object o = stuClass.newInstance(); //o的运行类型是student
        System.out.println(o.getClass());//class com.zledu.reflection.student
        //3.使用反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o, 99);//通过反射来操作属性
        System.out.println(o);
        System.out.println(age.get(o));//返回age属性的值

        //4.使用反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        //对name进行 爆破，可以操作private属性
        name.setAccessible(true);
        //name.set(0, "jack");
        name.set(null, "jack~"); //因为name是static属性，因此 o 也可以写成null
        System.out.println(o);
        System.out.println(name.get(o));//获取属性值
        System.out.println(name.get(null));//获取属性值，要求name是 static

    }
}
class student{
    public int age;
    private static String name;

    public student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "age=" + age +
                ",name=" + name +
                '}';
    }
}