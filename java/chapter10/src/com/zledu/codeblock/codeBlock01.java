package com.zledu.codeblock;

public class codeBlock01 {
    public static void main(String[] args) {
        movie movie1 = new movie("唐探3");
        System.out.println("------------");
        movie movie2 = new movie("三体", 100, "刘慈欣");

    }
}

class movie{
    private String name;
    private int price;
    private String director;

    /**
     * 3个构造器 构成了 重载
     * (1) 下面三个构造器都有相同的语句
     * (2) 这样代码看起来比较冗余
     * (3) 这样我们把相同的语句放入代码块中，即可
     * (4) 这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容
     * (5) 代码块调用的顺序优先于构造器
     */
    {
        System.out.println("电影开始");
        System.out.println("电影经行");
        System.out.println("电影结束");
    };

    public movie(String name) {
        System.out.println("movie(String name) 被调用");
        this.name = name;
    }

    public movie(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public movie(String name, int price, String director) {
        System.out.println("movie(String name, int price, String director)");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}