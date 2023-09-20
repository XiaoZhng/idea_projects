package com.zledu.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        /*
          使用 HashMap添加三个员工对象，键：员工id 值：员工对象
          并遍历显示工资>18000的员工(遍历方式至少两种)
         */
        HashMap map = new HashMap();
        map.put("NO1", new Person("jack", 20000.0, 001));
        map.put("NO2", new Person("tom", 15000, 002));
        map.put("NO3", new Person("lucy", 25000, 003));

        //遍历
        //方式一：通过键来遍历
        Set keyset = map.keySet();
        for (Object key : keyset){
            //先获取value，然后向下转型成 Person
            Person value = (Person)map.get(key);
            if (value.getSallary() > 18000) {
                System.out.println("员工id:" + key + " 员工对象:" + map.get(key));
            }
        }

        System.out.println("=======================");
        //方式二：通过EntrySet来遍历
        Set enstyr = map.entrySet();
        Iterator iterator = enstyr.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            //Map.Entry entry = (Map.Entry)iterator.next();
            //向下转型 Map.Entry调用 getkey getValue
            Map.Entry entry = (Map.Entry) obj;
            //转成 Map.Entry类型后，调用getValue()获取对象，再向下转型成 Person
            Person value = (Person)entry.getValue();
            if (value.getSallary() > 18000) {
                System.out.println("员工id:" + entry.getKey() + " 员工对象：" + entry.getValue());
            }
        }

    }
}

class Person{
    private String name;
    private double sallary;
    private int id;

    public Person(String name, double sallary, int id) {
        this.name = name;
        this.sallary = sallary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sallary=" + sallary +
                ", id=" + id +
                '}';
    }
}