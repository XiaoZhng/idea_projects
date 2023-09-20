package com.zledu.generic.homework;

import java.util.*;

public class Homeworks1 {
    public static void main(String[] args) {

        DAO1<User1> user = new DAO1<>();
        user.save("001", new User1(1,10, "jack"));
        user.save("002", new User1(2, 20, "Tom"));
        user.save("003", new User1(3, 30, "lucy"));
        System.out.println(user.list());

        System.out.println(user.get("003"));//lucy
        System.out.println(user.get("001"));//jack

        user.update("001", new User1(5, 50, "Jams"));
        System.out.println(user.list());

        user.delete("002");
        System.out.println("======================");
        System.out.println(user.list());
        System.out.println(user.get("002"));
    }
}
@SuppressWarnings({"all"})
//定义一个泛型类
class DAO1<T>{
    //定义一个Map成员变量，Map键为 String，值为 T
    //分析得出，创建一个HashMap，实例名为Map
    private HashMap<String, T> map = new HashMap<>();//Map成员变量

    //创建方法
    public void save(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id, entity);
    }
    //返回 map 中存放的所有T对象
    //就是把map集合中所有的value(T 对象)值放入 List集合中，返回即可
    public List<T> list(){
        List<T> list = new ArrayList();
        //通过map的enttrySet获取到key，从而得到value
        Set<Map.Entry<String, T>> entries = map.entrySet();
        //迭代器遍历
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> next = iterator.next();
            list.add(next.getValue());
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }

}

//定义一个User1类
class User1{
    private int id;
    private int age;
    private String name;

    public User1(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}