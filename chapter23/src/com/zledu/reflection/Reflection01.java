package com.zledu.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Alonso
 */
public class Reflection01 {
    public static void main(String[] args) throws Exception {

        //1、也可以使用properties，读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.zledu.Cat"
        String methodName = properties.get("method").toString();//"h1"

        //3、使用反射机制解决
        //(1)加载类，返回Class类型的对象
        Class aClass = Class.forName(classfullpath);
        //(2)通过 aClass 得到你加载的类 com.zledu.Cat 的对象实例
        Object o = aClass.newInstance();
        System.out.println("o的运行类型=" + o.getClass());//class com.zledu.Cat
        //(3)通过 aClass得到你加载的类 com.zledu.Cat 的 methodName 的方法对象
        //   即：在反射中，可以把方法视为对象(万物皆对象)
        Method method1 = aClass.getMethod(methodName);
        //(4)通过method1 调用方法：即通过方法对象来实现调用方法
        System.out.println("===============");
        //传统方法：对象.方法()，反射机制：方法.invoke(对象)
        method1.invoke(o);

        //java.lang.reflect.Field：代表类的成员变量，Field对象表示某个类的成员变量
        //得到name字段
        Field nameField = aClass.getField("age");
        System.out.println(nameField.get(o)); //传统方法：对象.成员变量，反射机制：成员变量对象.get(对象)

        //java.lang.reflect.Constructor：代表类的构造方法，Constructor对象表示构造器
        Constructor constructor = aClass.getConstructor(); //()中可以指定构造器参数类型，返回无参构造器
        System.out.println(constructor);
        Constructor constructor1 = aClass.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
