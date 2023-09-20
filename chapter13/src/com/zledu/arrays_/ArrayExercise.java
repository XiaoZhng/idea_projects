package com.zledu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {

        //(1)按照price从大到小 (2)从小到大 (3)按书名长度从大到小

        Book[] books = new Book[4];
        books[0] = new Book("心流", 49);
        books[1] = new Book("被讨厌的勇气", 55);
        books[2] = new Book("牧羊少年奇幻之旅", 35);
        books[3] = new Book("季羡林散文集", 90);
//        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i]);
//        }

        /**
         * 自己思路：
         * (1) 完成 (1)按照price从大到小 使用 Arrays.sort()的定制排序
         */
//        PriceSort(books);
//        System.out.println(Arrays.toString(books));

        //(1)按照price从大到小
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                int bookValue = book1.getPrice() - book2.getPrice();
//                if (bookValue > 0){
//                    return -1;
//                }else if (bookValue < 0){
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });

        //(2)从小到大
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                int bookValue = book1.getPrice() - book2.getPrice();
//                if (bookValue > 0){
//                    return 1;
//                }else if (bookValue < 0){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        });

        //(3)按书名长度从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                //要求按照书名长度排序，长度就是int，所以直接可以返回
                return book2.getName().length() - book1.getName().length();
            }
        });


        System.out.println(Arrays.toString(books));

    }
//    public static void PriceSort(Book[] books){
//        Book temp;
//        for (int i = 0; i < books.length - 1; i++){
//            for (int j = 0; j < books.length - 1 - i; j++){
//                //如果前面的价格 比 后面的价格高，则替换
//                if (books[j].getPrice() < books[j + 1].getPrice()){
//                    temp = books[j];
//                    books[j] = books[j + 1];
//                    books[j + 1] = temp;
//                }
//            }
//        }
//    }
}

class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}