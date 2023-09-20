package com.zledu.generic.exercise_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Exercise05 {
    public static void main(String[] args) {

    }

    //Junit 测试类
    @Test
    public void Test(){
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 10, "jack"));
        dao.save("002", new User(2, 20, "tom"));
        dao.save("003", new User(3, 30, "lucy"));

        System.out.println(dao.get("001"));
        dao.update("004", new User(20, 40, "tim"));
        System.out.println(dao.get("004"));

        dao.delete("003");
        System.out.println(dao.get("003"));
        System.out.println(dao.list());
    }
}
class DAO<T>{
    private HashMap<String, T> map = new HashMap<>();

    //保存T类型对象到Map成员变量中
    public void save(String id, T entity){
        map.put(id, entity);
    }

    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }

    //替换map中key为id的内容，改为entity对象
    public void update(String id, T entity){
        map.put(id, entity);
    }

    //返回map中存放的所有T对象
    public List<T> list(){
        List<T> list = new ArrayList<>();

        Set<String> keyset = map.keySet();
        for (String key :keyset) {
            list.add(get(key));
        }

        return list;
    }

    //删除指定id 对象
    public void delete(String id){
        map.remove(id);
    }


}