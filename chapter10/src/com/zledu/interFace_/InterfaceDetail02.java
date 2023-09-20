package com.zledu.interFace_;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        //证明：接口中的属性只能是final的，而且是public static final 修饰符
        //接口中属性的访问形式：[接口名.属性名]
        System.out.println(IB.n1);//static证明：只有static才能用【类名.属性名】访问
        //IB.n1 = 20; //final证明：IB类中的n1属性不能被修改
        //public证明：用包外面的类调用，可以调用，就证明不是默认的
    }
}
//接口的默认修饰符只能是 public 和 默认，这点和类的修饰符是一样的
interface IB{
    //接口中的属性只能是final的，而且是public static final 修饰符。比如 public static final int n1 = 10;(必须初始化)
    int n1 = 10; //等价于 public static final int n1 = 10;
    void hi();
}
interface IC{
    void ok();
}
//接口不能继承其他类，但可以继承多个别的接口
interface ID extends IB,IC{}
//1.一个类同时可以实现多个接口
class pig implements IB,IC{

    @Override
    public void hi() {

    }

    @Override
    public void ok() {

    }
}
