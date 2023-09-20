package com.zledu.interFace_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        //new IA(); //错误
    }
}

//1.接口不能被实例化
//2.接口中所有的方法是 public方法，接口中抽象方法，可以不用abstract修饰
//3.一个普通类实现接口，就必须将该接口的所有方法都实现，可以使用Alt+Enter来解决
//4.抽象类去实现接口时，可以不用实现接口中的抽象方法
interface IA{//接口
    void hi();
    void say();
}
class cat implements IA{
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}
abstract class tiger implements IA{}