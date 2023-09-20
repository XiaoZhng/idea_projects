package com.zledu.reflection.class_;

import com.zledu.Car;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Alonso
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        String classPath = "com.zledu.Car";
        //1.获取到Car类 对应的 Class对象
        //<?> 表示不确定Java类型
        Class<?> aClass = Class.forName(classPath);
        //2.输出aClass
        System.out.println(aClass);//显示aClass对象，是哪个类的Class对象 com.zledu.Car
        System.out.println(aClass.getClass());//输出aClass的运行类型 java.lang.Class

        //3.得到包名
        System.out.println(aClass.getPackage().getName());//com.zledu

        //4.得到全类名
        System.out.println(aClass.getName());//com.zledu.Car

        //5.通过aClass创建对象实例
        Car car = (Car)aClass.newInstance();
        System.out.println(car);//Car{brand='宝马', price=500000, color='白色'}

        //6.通过反射获取属性 brand
        Field brand = aClass.getField("brand");
        System.out.println(brand.get(car));//宝马

        //7.通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));//奔驰

        //8.得到所有的属性
        Field[] fields = aClass.getFields();
        for (Field f : fields){
            System.out.println(f.getName());
        }

        int[] num = new int[]{0,0,4,2,5,0,3,0};
        ArrayList arrayList = new ArrayList();
        arrayList.add(num);
        int k = 0;
        Integer integer = new Integer(0);
        while (k < arrayList.size()){
            if (arrayList.get(k).equals(integer)){
                arrayList.remove(k);
            }
            k++;
        }
        System.out.println(arrayList);

    }
}
