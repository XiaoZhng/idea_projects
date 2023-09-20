package com.zledu.extend_.improve_;

public class Sub extends Base{ //子类

    public Sub(String name, int age){
        //1.调用无参构造器，如下：   默认调用super()，或者什么都不写
        //super();

        //2.父类Base(String name)构造器，如下：
        //super("tim");

        //3.父类Base(String name, int age)构造器，如下：
        super("tom",20);

        //细节：super在使用时，必须放在构造器第一行(super只能在构造器中使用)
        //细节：super() 和 this() 都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
        //this(); 不能再使用了
        System.out.println("子类Sub(String name, int age)构造器被调用...");
    }

    public Sub(){ //无参构造器
        /*如果父类没有提供无参构造器，则必须在子类的构造器中使用super()去指定使用父类的哪个
        构造器完成对父类的初始化，否则编译不通过*/
        super("tim", 10);
        //super(); //默认调用父类的无参构造器
        System.out.println("子类sub()构造器被调用...");
    }
    //当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
    public Sub(String name){ //有参构造器
        super("tom", 30);
        System.out.println("子类Sub(String name)构造器被调用...");
    }

    public void sayOK(){
        //非私有的属性和方法可以在子类直接访问
        //但是私有的属性和方法不能在子类直接访问
        System.out.println(n1 + " " + n2 + " " + n3 + " ");
        test100();
        test200();
        test300();
        //test400(); 错误
        //要通过父类提供的公共方法去访问
        System.out.println("n4=" + getN4());
        callN4();

    }
}
