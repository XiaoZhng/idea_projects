package com.zledu.innerclass.exercise_;

public class Exercise01 {
    public static void main(String[] args) {
        //类的五大成员：属性、方法、构造器、代码块、内部类
        /**
         * 局部内部类：
         * 匿名内部类：
         */

//        outher outher = new outher();
//        outher.hi();

        //传统方式
//        tiger tiger = new tiger();
//        tiger.say();
        //匿名内部类
        //编译类型：IA
        //运行类型：匿名内部类 Exercise01$1

        outher02 outher02 = new outher02();
        outher02.hi();


    }
}
class outher02{
    private int n2 = 100;
    public void hi(){
        IA tiger = new IA(){
            private int n2 = 200;
            @Override
            public void say() {
                System.out.println("老虎吼叫...");
                System.out.println("n2= " + n2 + " 外部类n2= " + outher02.this.n2);
            }
        };
        tiger.say();
        System.out.println(tiger.getClass());

        //基于类的匿名内部类
        father father = new father("jack"){
            @Override
            public void f1() {
                System.out.println("匿名内部类 f1()...");
            }
        };
        father.f1();

        //基于抽象类的匿名内部类
        new Car(){
            @Override
            void ber() {
                System.out.println("汽车飞驰着...");
            }
        }.ber();
    }
}

interface IA{
    void say();
}
class father{
    private String name;

    public father(String name) {
        this.name = name;
        System.out.println("father name= " + name);
    }

    public void f1(){
        System.out.println("father f1()...");
    }
}
abstract class Car{ //抽象类
    abstract void ber();
}

//class tiger implements IA{
//    @Override
//    public void say() {
//        System.out.println("老虎叫...");
//    }
//}

class outher{ //外部类
    private int n1 = 10;
    public void hi(){
        final class inner{ //内部类
            private int n1 = 100;
            public void ok(){
                System.out.println("内部类中 ok()" + n1 + " 外部类的n1= " + outher.this.n1);
            }
        }
        //class cat extends inner{}
        new inner().ok();
    }
}