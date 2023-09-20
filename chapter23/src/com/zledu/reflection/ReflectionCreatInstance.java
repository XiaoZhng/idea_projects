package com.zledu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Alonso
 * 演示通过反射机制创建实例
 */
public class ReflectionCreatInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //1.先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.zledu.reflection.User");
        //2.通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3.通过public的有参构造器创建实例
        /*
            constructor对象就是
            public User(String name) { //public构造器
                this.name = name;
            }
         */
        //3.1 先得到对应的构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例，并传入实参
        Object tom = constructor.newInstance("tom");
        System.out.println("tom= " + tom);
        //4.通过非public的有参构造器创建实例
        //4.1 得到private的构造器对象
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //爆破【暴力破解】，使用反射可以访问private构造器/方法/属性
        declaredConstructor.setAccessible(true);
        Object zhang = declaredConstructor.newInstance(100, "张三");
        System.out.println("zhang= " + zhang);
    }
}
class User{
    private int age = 10;
    private String name = "jack";

    public User() { //无参构造器
    }

    public User(String name) { //public构造器
        this.name = name;
    }

    private User(int age, String name) { //private构造器
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}