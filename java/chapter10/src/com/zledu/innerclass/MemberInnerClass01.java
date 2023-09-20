package com.zledu.innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
//        outer08.hi();

        //外部其他类，访问成员内部类的三种方式
        //第一种方式
        //outer08.new Inner08(); 相当于把new Inner08()当做是outer08成员
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();

        //第二种方式：在外部类中，编写一个方法，可以返回Inner08对象
        Outer08.Inner08 getInner08 = outer08.getInner08();
        getInner08.say();
    }
}

class Outer08 {//外部类
    private int n1 = 10;
    public String name = "张三";

    public void ok() {
        System.out.println("ok()");
    }

    //1.注意：成员内部类，是定义在外部类的成员位置上
    //2.可以添加任意访问修饰符(public、protect、默认、private)，因为它的地位就是一个成员
    class Inner08 {//成员内部类
        private double n2 = 99.9;

        public void say() {
            //可以直接访问外部类的所有成员，包含私有的
            System.out.println("n1=" + n1 + " name=" + name);
            ok();
        }
    }

    public void hi() {
        //使用成员内部类
        //创建成员内部类的对象，然后使用相关的方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.n2);
    }

    //方法，返回一个Inner08
    public Inner08 getInner08() {
        return new Inner08();
    }
}