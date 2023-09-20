package com.zledu.static_;

public class VisitStatic {
    public static void main(String[] args) {

        //类名.类变量名
        //说明：类变量是随着类的加载而创建的，所以即使没有创建对象实例也可以访问
        System.out.println(A.name);

        A a = new A();
        //对象名.类变量名
        System.out.println("a.name=" + a.name);
    }
}

class A{
    //类变量
    //类变量的访问，必须遵守 相关的访问权限
    public static String name = "jack";
}