package com.zledu.poly_;

public class PolyExercise02 {
    public static void main(String[] args) {
//        Sub s = new Sub();
//        System.out.println(s.count); //20 查找属性看编译类型
//        s.display(); //20 查找方法看运行类型
//
//        Base b = s; //子类s指向父类b 向上转型 s赋给b s指向Sub，b也指向Sub
//        System.out.println(b == s); //True
//        System.out.println(b.count); //10 查找属性看编译类型
//        b.display(); //20 查找方法看运行类型
    }
}
class Base{
    int count = 10;
    public void display(){
        System.out.println(this.count);
    }
}

class Sub extends Base{
    int count = 20;
    public void display(){
        System.out.println(this.count);
    }
}
