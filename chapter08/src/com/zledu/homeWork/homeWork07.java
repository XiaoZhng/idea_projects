package com.zledu.homeWork;

public class homeWork07 {
}

class Test{ //父类
    String name = "Rose";
    Test(){
        System.out.println("Test");
    }
    Test(String name){ //name = john
        this.name = name; //属性的动态绑定机制，哪里声明就在哪里使用，所以改变本类的name
    }
}

class Demo extends Test{ //子类
    String name = "Jack";
    Demo(){
        super();
        System.out.println("Demo");
    }
    Demo(String s){
        super(s);
    }
    public void test(){
        System.out.println(super.name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new Demo().test(); //匿名对象
        new Demo("john").test(); //匿名对象
        //Test Demo Rose Jack
        //john Jack
    }
}