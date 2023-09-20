package com.zledu.codeblock;

public class codeBlockDetail03 {
    public static void main(String[] args) {
        //输出顺序：(1)AAA代码块调用 (2)AAA() 构造器调用 (3)BBB代码块调用 (4)BBB() 构造器调用
        new BBB();
    }
}

class AAA{

    {
        System.out.println("AAA代码块调用");
    }

    public AAA() {
        //(1)suuper();
        //(2)调用本类的普通代码块
        System.out.println("AAA() 构造器调用");
    }
}
class BBB extends AAA{

    {
        System.out.println("BBB代码块调用");
    }

    public BBB() {
        //(1)suuper();
        //(2)调用本类的普通代码块
        System.out.println("BBB() 构造器调用");
    }
}