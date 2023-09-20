package com.zledu.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Alonso
 * 反射问题的引入
 */
public class RefilectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //根据配置文件 re.properties 指定信息，创建Cat对象并调用方法h1

        //传统方法
        //Cat cat = new Cat();
        //cat.hi(); 传统方法 ==> 修改源码 cat.cry();
        //反射机制 修改配置文件即可

        //1、也可以使用properties，读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.zledu.Cat"
        String methodName = properties.get("method").toString();//"h1"
        System.out.println("classfullpath=" + classfullpath + " method=" + methodName);

        //2、创建对象，传统方法，行不通
        //new classfullpath();

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

    }
}
