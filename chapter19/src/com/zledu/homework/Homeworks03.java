package com.zledu.homework;

import java.io.*;
import java.util.Properties;

/**
 * @author Alonso
 */
public class Homeworks03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //编写 dog.properties
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
//        properties.list(System.out);

        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        //编写dog类(name,age,color)，读取 dog.properties 用相应内容完成属性初始化，并输出
        Dog dog = new Dog(name, age, color);
        System.out.println("Dog对象=" + dog);
        //dog对象，序列化到文件 dog.dat文件
        String filePath = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog);
        oos.close();
        System.out.println("dog序列化完成");

        //反序列化
        deserialization(dog, filePath);

    }
    //创建方法反序列化
    public static void deserialization(Dog dog, String filePath) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Object o = ois.readObject();
        //向下转型
        Dog dog1 = (Dog) o;
        System.out.println("反序列化信息=========");
        System.out.println("dog1的运行类型=" + dog1.getClass());
        System.out.println(dog1);

        //关闭流
        ois.close();
    }
}
class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}