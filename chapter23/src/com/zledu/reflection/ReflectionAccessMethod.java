package com.zledu.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Alonso
 * 演示通过反射调用方法
 */
public class ReflectionAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //1.得到Boss类对应的Class对象
        Class<?> bossClass = Class.forName("com.zledu.reflection.Boss");
        Object o = bossClass.newInstance();
        //2.使用反射得到age属性对象
        Field age = bossClass.getField("age");
        age.set(o, 22);
        //3.使用反射得到name属性对象
        Field name = bossClass.getDeclaredField("name");
        name.setAccessible(true);//爆破
        name.set(0, "tim");
        System.out.println(o);
        //4.使用反射得到public hi方法
        //4.1 得到hi方法对象
        //Method say = bossClass.getMethod("hi");
        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        //hi.invoke(o, name.get(o));
        hi.invoke(o, "jack");

        //5.使用反射得到private say方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class);
        say.setAccessible(true);//爆破
        System.out.println(say.invoke(o, 10, "king"));
        //System.out.println(say.invoke(o, age.get(o), name.get(o)));
        //因为say方法是static，还可以这样调用，对象传入null
        System.out.println(say.invoke(null, 20, "张三"));

        //6.在反射中，如果方法有返回值，统一返回Object，但是它的运行类型和方法定义的返回类型一致
        Object lisi = say.invoke(null, 30, "李四");
        System.out.println("lisi的运行类型= " + lisi.getClass());//class java.lang.String
    }
}

class Boss{
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int age, String name){
        return age + " " + name;
    }
    public void hi(String name){
        System.out.println("hi," + name);
    }

    @Override
    public String toString() {
        return "Boss{" +
                "age=" + age +
                ",name=" + name +
                '}';
    }
}