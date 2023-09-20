package com.zledu.reflection.class_;

import com.zledu.Car;

/**
 * @author Alonso
 * 演示得到Class对象的各种方式(6种)
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

        //1.forName()，应用场景：多用于配置文件，读取类全路径，加载类
        String ClassFile = "com.zledu.Car";
        Class cls1 = Class.forName(ClassFile);
        System.out.println(cls1);

        //2.类名.class，通过类的class获取，该方式最为安全可靠，程序性能最高
        //应用场景：多用于参数传递，比如通过反射得到对于构造器对象
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3.对象.getClass()，应用场景：通过创建好的对象，获取Class对象
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器【4种】来获取到类的Class对象
        //(1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass(ClassFile);
        System.out.println(cls4);

        //cls1,cls2,cls3,cls4   其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5.基本数据类型(int,char,boolean,float,double,long,short)得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int
        System.out.println(booleanClass);//boolean

        //6.基本数据类型对应的包装类，可以通过.TYPE得到Class对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Double> type2 = Double.TYPE;
        System.out.println(type1);//int

        //基本数据类型和包装类在底层通过反射进行自动拆箱和装箱的转换
        System.out.println(integerClass.hashCode());
        System.out.println(type1.hashCode());


    }
}
