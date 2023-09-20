package com.zledu.generic.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {

        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 10, "jack"));
        dao.save("002", new User(2, 20, "tom"));
        dao.save("003", new User(3, 30, "lucy"));
        System.out.println(dao.list());

        System.out.println(dao.get("002"));
        dao.delete("001");
        dao.update("004", new User(4, 40, "king"));
        System.out.println(dao.list());
    }
}

//泛型类
class DAO<T>{
    //定义一个Map成员变量，就是创建一个HashMap
    private HashMap<String, T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id, entity);
    }
    public List<T> list(){ //返回map中存放的所有T对象
        //创建ArrayList，用map通过 key 获取到 所有value，然后添加到ArrayList
        List<T> list = new ArrayList<>();
        Set<String> keyset = map.keySet(); //获取到所有的key
        for (String key : keyset) {
            list.add(get(key)); //list.add(map.get(key));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
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
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}