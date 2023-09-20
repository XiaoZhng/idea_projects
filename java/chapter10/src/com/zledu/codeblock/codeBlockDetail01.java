package com.zledu.codeblock;

public class codeBlockDetail01 {
    public static void main(String[] args) {

        //类加载的情况举例
        //1.创建对象实例时(new)
        //AA aa1 = new AA();
        //2.创建子类对象实例，父类也会被加载，而且，父类先被加载，子类后被加载
        //AA aa2 = new AA();
        //3.使用类的静态成员(静态属性，静态方法)
        //System.out.println(cat.n1);

        //static代码块，是在类加载时，执行的，而且只会执行一次
        //DD d1 = new DD();
        //DD d2 = new DD();

//        System.out.println(DD.n1);
        System.out.println(cat.n1);
    }
}
class DD{
    public static int n1 = 888;
    //静态代码块
    static {
        System.out.println("DD 的静态代码块被执行...");
    }

    //普通代码块，在new对象时，被调用，而且是每创建一个对象，就调用一次
    {
        System.out.println("DD 的静态代码块被执行...");
    }
}

class animal{
    //静态代码块
    static {
        System.out.println("animal 的静态代码块被执行...");
    }
}

class cat extends animal{
    //静态属性
    public static int n1 = 10;

    //静态代码块
    static {
        System.out.println("cat 的静态代码块被执行...");
    }
}

class BB{
    //静态代码块
    static {
        System.out.println("BB 的静态代码块被执行...");
    }
}

class AA extends BB{
    //静态代码块
    static {
        System.out.println("AA 的静态代码块被执行...");
    }
}