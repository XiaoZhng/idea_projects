package com.zledu.list_;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class ListExercise02 {

    public static void main(String[] args) {

        /*
            使用List的实现类添加三本图书，并遍历，
            (1) 按价格排序，从低到高(冒泡法)
            (2) 要求使用ArrayList、LinkedList、Vector 三种集合实现
         */
        List list = new ArrayList();
        list.add(new Book("心流", "米哈里", 39.9));
        list.add(new Book("三体", "刘慈欣", 29.9));
        list.add(new Book("我们仨", "杨绛", 49.9));
        for (Object i : list){
            System.out.println(i);
        }

        //冒泡排序 可以把排序封装成方法，提高代码可读性
//        for (int i = 0; i < list.size() - 1; i++){
//            for (int j = 0; j < list.size() - 1 - i; j++){
//                //list.get(j)的运行类型是Object，所以无法调用Book类型的价格，通过向下转型才能调用
//                Book book1 = (Book)list.get(j);
//                Book book2 = (Book)list.get(j+1);
//                if (book1.getPrice() > book2.getPrice()){//第一本书价格 大于 第二本书价格，则交换
//                    list.set(j, book2);
//                    list.set(j+1, book1);
//                }
//            }
//        }
        sort(list);

        System.out.println("排序后===========");
        for (Object i : list){
            System.out.println(i);
        }

    }
    public static void sort(List list){
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = 0; j < list.size() - 1 - i; j++){
                //list.get(j)的运行类型是Object，所以无法调用Book类型的价格，通过向下转型才能调用
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if (book1.getPrice() > book2.getPrice()){//第一本书价格 大于 第二本书价格，则交换
                    list.set(j, book2);
                    list.set(j+1, book1);
                }
            }
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