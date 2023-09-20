package com.zledu.innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {//外部类
    private int n1 = 10;

    public void method() {
        //基于接口的匿名内部类
        /**
         * 1.需求：想使用IA接口，并创建对象
         * 2.传统方式：创建一个类，实现接口，并创建对象
         * 3.需求是 tiger/dog 类只是使用一次，后面不再使用
         * 4.可以使用匿名内部类来简化开发    IA tiger = new IA(){};
         * 5.tiger的编译类型 ？ IA
         * 6.tiger的运行类型 ？ 就是匿名内部类 XXX = Outer04$1
         * 我们看底层 会分配 类名 Outer04$1
         *    class Outer04$1 implements IA{
         *       @Override
         *       public void cry() {
         *           System.out.println("老虎叫唤...");
         *       }
         *    }
         *
         * 7.jdk底层在创建匿名内部类 Outer04$1，立即马上就创建了 Outer04$1实例，并且把地址返回给 tiger
         * 8.匿名内部类使用一次，就不能使用
         */

        IA tiger = new IA(){
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        tiger.cry();
        System.out.println("tiger的运行类型=" + tiger.getClass());

//        IA tiger = new tiger();//传统方式创建
//        tiger.cry();

        //基于类的匿名内部类
        /**
         * 1.father编译类型 Father
         * 2.father运行类型 Outer04$2
         * 3.在底层会创建匿名内部类
         *  class Outer04$2 extends Father{
         *      @Override
         *      public void test() {
         *          System.out.println("匿名内部类重写test()");
         *      }
         *  }
         *  4.同时也直接返回了 匿名内部类 Outer04$2的对象
         *  5.注意("jack") 参数列表会传递给 构造器
         */
        Father father = new     Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写test()");
            }
        };
        System.out.println("father运行类型=" + father.getClass());
        father.test();

        //基于抽象类的匿名内部类
        Animal animal = new Animal(){
            @Override
            void eat() {
                System.out.println("吃东西");
            }
        };
        animal.eat();
    }
}

interface IA {
    public void cry();
}
//class tiger implements IA{
//    @Override
//    public void cry() {
//        System.out.println("老虎叫唤...");
//    }
//}
//class dog implements IA{
//    @Override
//    public void cry() {
//        System.out.println("小狗交换...");
//    }
//}
class Father {
    public Father(String name) {
        System.out.println("构造器name=" + name);
    }

    public void test() {

    }
}
abstract class Animal{
    abstract void eat();
}