package com.zledu;

import java.util.*;

@SuppressWarnings({"all"})
public class TestAll {
    public static void main(String[] args) {

        //==============================Collection============================================

        //Iterator迭代器
//        Collection arrayList = new ArrayList();
//        arrayList.add("jack");
//        arrayList.add("tom");
//        arrayList.add("lucy");
//
//        Iterator iterator = arrayList.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//            System.out.println(next);
//            //System.out.println(iterator.next());
//        }

//        System.out.println("第二次遍历==================");
//        //如果希望再次遍历，需要重置迭代器
//        iterator = arrayList.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//            System.out.println(next);
//        }

//        System.out.println("增强for遍历================");
//        for (Object obj : arrayList){
//            System.out.println(obj);
//        }

        //==============================List接口============================================

        /*
             添加10个以上的元素(比如String "hello") 在2号位插入一个元素，获得第五个元素
             删除第6个元素，修改第七个元素，再使用迭代器遍历集合
         */
//        List list = new ArrayList();
//        for (int i = 1; i <= 10; i++) {
//            list.add("hello" + i);
//        }
//        System.out.println(list);
//        System.out.println(list.get(5));//hello6
//        System.out.println(list.remove(6));//hello7
//        System.out.println(list.set(7, "lucy"));
//        System.out.println(list);
//        Iterator iterator1 = list.iterator();
//        while (iterator1.hasNext()) {
//            Object next = iterator1.next();
//            System.out.println(next);
//        }
        /*
            使用List的实现类添加三本图书，并遍历，
            (1) 按价格排序，从低到高(冒泡法)
            (2) 要求使用ArrayList、LinkedList、Vector 三种集合实现
         */
//        List list = new ArrayList();
//        list.add(new Books("心流", "米哈里", 39.9));
//        list.add(new Books("三体", "刘慈欣", 29.9));
//        list.add(new Books("我们仨", "杨绛", 49.9));
//        list.add(null);
//        list.add(null);


        //编写方法，实现价格排序
//        sort(list);
//        System.out.println("排序后= " + list);

        //==============================Set接口============================================

        //Collection set = new HashSet();
        Set hashSet = new HashSet();
        hashSet.add("jack");
        hashSet.add("tom");
        hashSet.add("lucy");
        hashSet.add("jack");
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("HashSet= " + hashSet); //无序、不能重复、只能有一个null

        //迭代器遍历
        System.out.println("迭代器遍历==================");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        System.out.println("增强for遍历==================");
        for (Object o :hashSet) {
            System.out.println(o);
        }

        //不能获取索引，所以不能使用普通for
//        for (int i = 0; i < hashSet.size(); i++) {
//            System.out.println(hashSet.?);
//        }

        //==============================Map接口============================================

        /*
          使用 HashMap添加三个员工对象，键：员工id 值：员工对象
          并遍历显示工资>18000的员工(遍历方式至少两种)
         */
        HashMap hashMap = new HashMap();
        hashMap.put("001", new Person("jack", 20000.0));
        hashMap.put("002", new Person("tom", 16000.0));
        hashMap.put("003", new Person("lucy", 19000.0));

        System.out.println("增强for遍历=================");
        Set keyset = hashMap.keySet();
        for (Object key :keyset) {
            Person value = (Person)hashMap.get(key);
            if (value.getSallary() > 18000){
                System.out.println(key + "-" + hashMap.get(key));
            }
        }

        System.out.println("迭代器遍历=================");
        Set entrySet = hashMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry next = (Map.Entry)iterator1.next();
            Person entry = (Person)next.getValue();
            if (entry.getSallary() > 18000){
                System.out.println(next.getKey() + "-" + next.getValue());
            }
        }


    }
    public static void sort(List list){
        if (list == null){
            return;
        }
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1-i; j++){
                Books books1 = (Books)list.get(j);
                Books books2 = (Books)list.get(j + 1);
                if (books1.getPrice() > books2.getPrice()){
                    list.set(j, books2);
                    list.set(j+1, books1);
                }
            }
        }
    }

}

class Books{
    private String name;
    private String author;
    private double price;

    public Books(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nBooks{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
class Person{
    private String name;
    private double sallary;

    public Person(String name, double sallary) {
        this.name = name;
        this.sallary = sallary;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sallary=" + sallary +
                '}';
    }
}