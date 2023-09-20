package com.zledu.arrays_.exercise_;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise01 {
    public static void main(String[] args) {

        Book[] books = new Book[3];
        books[0] = new Book("三体1", 39);
        books[1] = new Book("三体22", 29);
        books[2] = new Book("三体333", 49);

        //注意：比较器重写的compare()是int类型，如果设置的价格是double
        //     可以接收两个double价格相减的值，再判断是否大于小于0，然后返回个整数即可

        //按价格从大到小
        //使用到泛型 Book
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
//                Book book1 = (Book)o1;
//                Book book2 = (Book)o2;
//                return book1.getPrice() - book2.getPrice();
                return o1.getPrice() - o2.getPrice();
            }
        });
        System.out.println("价格大到小= " + Arrays.toString(books));

        //按价格从小到大
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        System.out.println("价格小到大= " + Arrays.toString(books));

        //按照书名长度
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });
        System.out.println("按照书名长度大到小= " + Arrays.toString(books));
    }
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