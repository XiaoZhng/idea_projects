package com.zledu.single_;

public class SingleTon02 {
    public static void main(String[] args) {


//        System.out.println(Cat.getInstance());
//        System.out.println(Cat.n1);

        new dog().say();
    }
}

class Cat{
    private String name;
    public static int n1 = 10;
    private static Cat cat;//默认是null

    /**
     * 步骤：
     * 1.仍然构造器私有化
     * 2.定义一个static静态属性对象
     * 3.提供一个静态的公共方法，返回一个cat对象
     * 4.懒汉式，只有当用户使用getInstance时，才返回cat对象，后面再次调用时，会返回上次创建的cat
     * 从而保证了单例
     */
    private Cat(String name) {
        System.out.println("gzq调用");
        this.name = name;
    }

    public static Cat getInstance(){

        if (cat == null){ //如果还没有创建cat对象
            cat = new Cat("tom");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

class dog{ //外部类
    private int n1 = 10;
    public void m1(){
        System.out.println("m1()");
    }
    {
        class ooo{
            public void ok(){
                System.out.println(n1);
                m1();
            }
        }
    }

    public void say(){
        System.out.println("say()");
        final class ttt{//局部内部类
            private int n1 = 100;
            public void hi(){
                System.out.println("外部n1=" + dog.this.n1 + " 内部n1=" + ttt.this.n1);
                m1();
            }
        }
        new ttt().hi();
    }
}