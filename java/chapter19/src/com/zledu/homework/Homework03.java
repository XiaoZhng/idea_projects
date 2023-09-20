package com.zledu.homework;

import java.io.*;
import java.util.Properties;

/**
 * @author Alonso
 */
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //编写 dog.properties
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");
        properties.store(new FileWriter("src\\dog.properties"), null);

        //编写dog类(name,age,color)，读取 dog.properties 用相应内容完成属性初始化，并输出
        String name = properties.getProperty("name");
        String color = properties.getProperty("color");
        dog dog = new dog(name, 10, color);
        System.out.println(dog);

        //dog对象，序列化到文件 dog.dat文件
        String filePath = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog);
        //关闭流
        oos.close();

        //反序列化
        String FilePath = "e:\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));
        Object o = ois.readObject();
        System.out.println("dog的信息=" + o);
    }
}
class dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}