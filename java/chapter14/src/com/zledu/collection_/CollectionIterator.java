package com.zledu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection list = new ArrayList();
        list.add(new Book("心流", "米哈里", 49.0));
        list.add(new Book("三体", "刘慈欣", 35.9));
        list.add(new Book("三体2", "刘慈欣", 39.9));

        //hasNext():判断是否还有下一个元素
        //next():作用:1.向下移 2.将下移以后集合位置上的元素返回
        //在调用 iterator.next() 方法之前必须调用 iterator.hasNext() 进行检测
        //若不调用，且下一条记录无效，直接调用 iterator.next() 会抛出NoSuchElementException异常

        //遍历list集合
        //1.先得到 list 对应的 迭代器
        Iterator iterator = list.iterator();//迭代器
        //2.使用while循环遍历
        while (iterator.hasNext()){//判断是否还有数据
            //返回下一个元素，类型是Object
            Object next = iterator.next();
            System.out.println("next=" + next);
        }

        //生成while + iterator 快捷键：itit
        //显示所有快捷键的快捷键：ctrl + j
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//
//        }

        //3.当退出while循环后，这时iterator迭代器，指向最后的元素
        //iterator.next();//NoSuchElementException
        //4.如果希望再次遍历，需要重置迭代器
        iterator = list.iterator();
        System.out.println("第二次遍历----------");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}
class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
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
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}