package com.zledu.generic;

import java.util.*;

public class GenericExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //放入HashSet中
        HashSet<Studend> set = new HashSet<>();
        set.add(new Studend("jack", 10));
        set.add(new Studend("tom", 20));
        set.add(new Studend("lucy", 30));
        for (Studend studend :set) {
            System.out.println(studend.getName() + "," + studend.getAge());
        }
        System.out.println("=================");
        Iterator<Studend> iterator = set.iterator();
        while (iterator.hasNext()) {
            Studend next =  iterator.next();
            System.out.println(next.getName() + "," + next.getAge());
        }

        //放入HashMap中
        //k -> String V -> Student
        /*
                public class HashMap<K,V>
         */
        //在定义的时候，就已经定义了泛型中的 <k, v> 为 <String, Student>
        HashMap<String, Studend> map = new HashMap<String, Studend>();
        map.put("1", new Studend("tim", 11));
        map.put("2", new Studend("Jams", 22));
        map.put("3", new Studend("Sam", 33));
        Set<Map.Entry<String, Studend>> entryset = map.entrySet();
        Iterator<Map.Entry<String, Studend>> iterator1 = entryset.iterator();
        /*
                    public final Iterator<Map.Entry<K,V>> iterator() {
                        return new EntryIterator();
                    }
         */

        while (iterator1.hasNext()) {
            Map.Entry<String, Studend> student = iterator1.next();
            System.out.println(student.getKey() + "," + student.getValue());
        }


    }
}
class Studend{
    private String name;
    private int age;

    public Studend(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Studend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}