package com.zledu.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);

    }
}

final class AAA{
    //一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法
    //public final void hi(){}
}

class BBB{
    //final和static往往搭配使用，效率更高，不会导致类加载。底层编译器做了优化处理
    public final static int num = 100;
    static {
        System.out.println("BBB代码块调用");
    }
}