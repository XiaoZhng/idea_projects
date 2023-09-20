package com.zledu.generic.exercise_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise02 {
    public static void main(String[] args) {
        //创建三个学生对象
        Student student1 = new Student("jack", 10);
        Student student2 = new Student("tom", 20);
        Student student3 = new Student("lucy", 30);

        //HashSet 放入学生对象
        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        //System.out.println(hashSet);

        //HashMap中，key是 String name， value是 学生对象
        HashMap<String, Student> hashMap = new HashMap<>(); //key=String, value=Student
        hashMap.put("jack", student1);
        hashMap.put("tom", student2);
        hashMap.put("lucy", student3);
        //System.out.println(hashMap);

        //用两种方式遍历
        System.out.println("HashSet遍历==============");
        for (Student o :hashSet) {
            System.out.println(o);
        }

        //Map接口使用entrySet遍历方式
        //先获取hashMap.entrySrt()
        //然后在使用增强for，遍历
        //通过向下转型,转成Map.Entry (或者直接把遍历类型Object改成Map.Entry，前提是entrySrt()使用了泛型)
        System.out.println("HashMap遍历===============");
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        for (Map.Entry o :entries) {
            //Map.Entry entry = (Map.Entry)o;
            //System.out.println(entry.getKey() + "-" + entry.getValue());
            System.out.println(o.getKey() + "-" + o.getValue());
        }


    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}