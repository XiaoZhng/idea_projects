package com.zledu.innerclass;


public class LocalInnerClass {//外部其他类
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode=" + outer02.hashCode());

    }
}

class Outer02{//外部类
    private int n1 = 100;
    private void m2(){
        System.out.println("Outer01 m1()");
    }

    public void m1(){//方法
        //1.局部内部类是定义在外部类的局部位置，通常在方法
        //3.不能添加访问修饰符，但是可以用final修饰,添加final后，在内部类中也不能被继承
        //4.作用域：仅仅在定义它的方法或代码块中
        final class Inner02{//局部内部类(本质仍是一个类)
            //7.如果外部类和局部内部类的成员重名时，默认遵循就近原则
            //  如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问
            private int n1 = 20;
            //2.可以直接访问外部类的所有成员，包括私有的
            public void f1(){
                //5.局部内部类可以直接访问外部类的成员，比如下面 外部类n1 和 m2()
                System.out.println("n1=" + n1 + " 外部类的n1=" + Outer02.this.n1);
                m2();
                System.out.println("Outer02.this hashcode=" + Outer02.this.hashCode());
            }
        }
        //6.外部类在方法中，可以创建局部内部类，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}

