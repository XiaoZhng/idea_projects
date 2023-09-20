package com.zledu.homework;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Alonso
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //利用Class；类的forName方法得到File类的class对象
        Class<?> fileClass = Class.forName("java.io.File");
        //打印file类的所有构造器
        Constructor<?>[] constructors = fileClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("file类的构造器= " + constructor);
        }
        //通过newInstance的方法创建File对象，并创建e:\\classA.txt文件

        //Class.newInstance()，只是得到加载类的对象实例，并不是创建对象，创建对象是通过构造器来创建的
        //fileClass.newInstance();

        //创建对象需要获取到构造器，先拿到构造器 public java.io.File(java.lang.String)
        Constructor<?> constructor = fileClass.getConstructor(String.class);
        String filePath = "e:\\classA.txt";
        //真正的通过构造器创建对象
        Object file = constructor.newInstance(filePath);//只是创建了file对象，还在内存中
        System.out.println(file.getClass()); //class java.io.File

        //创建e:\\classA.txt文件
        //需要拿到 File的 createNerFile方法
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(file);
        System.out.println("文件创建成功..");

    }
}
