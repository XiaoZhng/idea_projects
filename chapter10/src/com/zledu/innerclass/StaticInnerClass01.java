package com.zledu.innerclass;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.hi();

        //外部其他类 使用静态内部类
        //方式一：
        //因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();

        //方式二：
        //编写一个方法，可以返回静态内部类的对象实例
        Outer10.Inner10 getInner10 = outer10.getInner10();
        getInner10.say();
        System.out.println("--------------------------");
        Outer10.Inner10 inner10_ = Outer10.getInner10_();
        inner10_.say();

    }
}

class Outer10{//外部类
    private int n1 = 10;
    public static String name = "张三";
    private static void ok(){}
    //Inner10就是静态内部类
    /**
     * 1.放在外部类的成员位置
     * 2.使用static修饰
     * 3.可以直接访问外部类的所有静态成员，包括私有的，但不能直接访问非静态成员
     * 4.可以添加任意访问修饰符(public、protect、默认、private)，因为它的地位就是一个成员
     * 5.作用域：同其他成员，为整个类体
     * 6.静态内部类访问外部类(比如：静态属性)【访问方式：直接访问所有静态成员】
     * 7.外部类访问静态内部类【访问方式：创建对象，再访问】
     */
    static class Inner10{
        private static String name = "李四";
        public void say(){
            //如果外部类和静态内部类的成员重名时，静态内部类访问的话，默认遵循就近原则，
            //如果想访问外部类的成员，则可以使用(外部类名.成员)去访问
            System.out.println("静态内部类中的name=" + name + " 外部类中的name=" + Outer10.name);
            ok();
        }
    }

    public void hi(){//外部类访问静态内部类【访问方式：创建对象，再访问】
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10(){
        return new Inner10();
    }

    public static Inner10 getInner10_(){
        return new Inner10();
    }
}
