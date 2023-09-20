package com.zledu.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        System.out.println("main中 Outer05.this = " + outer05);
    }
}

class Outer05{
    private int n1 = 99;
    public void f1(){
        //创建一个基于类的匿名内部类
        //4.不能添加访问修饰符，因为它的地位就算是一个局部变量
        //5.作用域：仅仅在定义它的方法或代码块中
        Person person = new Person(){
            private int n1 = 10;
            @Override
            public void hi() {
                //3.可以直接访问外部类的所有成员，包含私有的
                //如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
                //默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问
                System.out.println("匿名内部类重写 hi() " + "匿名内部类的n1=" + n1 + " 外部类的n1=" + Outer05.this.n1);
                //Outer05.this 就是调用 f1的对象，谁调用f1，Outer05.this就是谁
                System.out.println("Outer05.this = " + Outer05.this);
            }
        };
        person.hi();//动态绑定，真实的运行类型是 Outer05$1

        //也可以直接调用，匿名内部类本身也是返回对象
//        new Person(){
//            @Override
//            public void hi() {
//                System.out.println("匿名内部类重写 hi()，第二种写法");
//            }
//        }.hi();
    }
}
class Person{
    public void hi(){
        System.out.println("Preson hi()");
    }
}