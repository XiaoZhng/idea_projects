package com.zledu.reflection.class_;

/**
 * @author Alonso
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {

        //Class类图
        //1.Class也是类，因此也继承Object类
        //Class

        //2.Class类对象不是new出来，而是系统创建的
        /* 传统new对象
           ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();

        //反射方式，没有debug到 ClassLoader类的 loadClass，原因是，没有注销 Cat cat = new Cat();
        /* ClassLoader类，仍然是通过 ClassLoad类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class aClass1 = Class.forName("com.zledu.Cat");

        //3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        Class aClass2 = Class.forName("com.zledu.Cat");
        Class<?> aClass3 = Class.forName("com.zledu.Dog");
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3  .hashCode());

    }
}
