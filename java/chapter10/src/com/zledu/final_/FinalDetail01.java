package com.zledu.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        DD dd = new DD();

        new FF().cal();
    }
}

//final修饰的属性又叫常量，一般用 XX_XX_XX 来命名
class AA{
    public final double TAX_RATE = 0.08;
}

/*
    final修饰的属性在定义时，必须赋初值，并且以后不能再修改，赋值可以在如下位置：

    1. 定义时，如 public final double TAX_RATE = 0.08;
    2. 在构造器中
    3. 在代码块中
 */
class BB{
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public BB() {//在构造器中
        TAX_RATE2 = 0.1;
    }
    {//在代码块中
        TAX_RATE3 = 0.2;
    }
}
//如果final修饰的属性是静态的，则初始化的位置只能是 (1)定义时 (2)在静态代码块，不能在构造器中赋值
class CC{
    public static final double TAX_RATE = 0.08; //定义时
    public static final double TAX_RATE2;
    static {//在静态代码块，不能在构造器中赋值
        TAX_RATE2 =- 0.1;
    }
}
//final类不能继承，但是可以实例化对象
final class DD{}

//如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承
//即，仍然遵守继承机制
class EE{
    public final void cal(){
        System.out.println("cal() 方法");
    }
}
class FF extends EE{

}