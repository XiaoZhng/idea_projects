package com.zledu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Alonso
 * 演示如何通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_02() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personClass = Class.forName("com.zledu.reflection.Person");

        //getDeclaredFields：获取本类所有属性
        //getModifiers：以int形式返回修饰符值
        //规定：【说明：默认修饰符是0、public是1、private是2、protected是4、static是8、final是16】
        //getType：返回属性对应的那个类的Class对象
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性= " + declaredField.getName()
             + " 该属性的修饰符值= " + declaredField.getModifiers()
             + " 该属性的类型= " + declaredField.getType());
        }

        //getDeclaredMethods：获取本类所有方法
        //getModifiers：方法的访问修饰符值
        //规定：【说明：默认修饰符是0、public是1、private是2、protected是4、static是8、final是16】

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法= " + declaredMethod.getName()
            + " 该方法的访问修饰符值= " + declaredMethod.getModifiers()
            + " 该方法的返回类型= " + declaredMethod.getReturnType());

            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型= " + parameterType);
            }
        }

        //getDeclaredConstructors：获取本类所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器= " + declaredConstructor.getName());//这里只是输出名字

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型= " + parameterType);
            }
        }

    }

    @Test
    public void api_01() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personClass = Class.forName("com.zledu.reflection.Person");

        //getName：获取全类名
        System.out.println(personClass.getName());//com.zledu.reflection.Person

        //getSimpleName：获取简单类名
        System.out.println(personClass.getSimpleName());//Person

        //getFields：获取所有 public修饰的属性，包含本类以及父类
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的属性= " + field.getName());
        }

        //getDeclaredFields：获取本类所有属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性= " + declaredField.getName());
        }

        //getMethods：获取所有 public修饰的方法，包含本类以及父类
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的方法= " + method.getName());
        }

        //getDeclaredMethods：获取本类所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法= " + declaredMethod.getName());
        }

        //getConstructors：获取本类所有 public修饰的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类所有的构造器= " + constructor.getName());
        }

        //getDeclaredConstructors：获取本类所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器= " + declaredConstructor.getName());//这里只是输出名字
        }

        //getPackage：以Package形式返回 包信息
        System.out.println(personClass.getPackage());//package com.zledu.reflection

        //getSuperclass：以Class形式返回父类信息
        System.out.println("父类的class对象= " + personClass.getSuperclass());//class com.zledu.reflection.A

        //getInterfaces：以Class[]形式返回接口信息
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息= " + anInterface);
        }

        //getAnnotations：以Annotation[] 形式返回注解信息
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息= " + annotation);
        }
    }
}

interface IA{}
interface IB{}

class A {
    public String hobby;
    public A(){}
    public void hi(){}
}

@Deprecated
class Person extends A implements IA, IB{
    //属性
    public static String name; //修饰符值：1+8=9
    protected int age;
    String job;
    private double sal;

    public Person(){

    }
    public Person(String name, int age, String job, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sal = sal;
    }

    //私有构造器
    private Person(int name){

    }

    //方法
    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return null;
    }

    void m3() {
    }

    private void m4() {
    }
}