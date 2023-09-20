package com.zledu.outputstream_;

import java.io.Serializable;

/**
 * @author Alonso
 */
//如果需要序列化某个类的对象，实现 Serializable
public class Dog implements Serializable {
    private String name;
    private int age;
    //SeriaIVersionUID 序列化的版本号，可以提高兼容性
    //private static final long SeriaIVersionUID = 1L;

    //序列化对象时，默认将里面所有属性都进行序列化，但除了 static 和 transient 修饰的成员
    private static String aa;
    private transient String bb;

    public Dog(String name, int age, String aa, String bb) {
        this.name = name;
        this.age = age;
        this.aa = aa;
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bb='" + bb + '\'' +
                '}' + aa;
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
}
