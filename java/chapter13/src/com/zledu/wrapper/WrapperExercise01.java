package com.zledu.wrapper;

public class WrapperExercise01 {
    public static void main(String[] args) {
        Double d = 100d;//ok，自动装箱 Double.valueOf(100d);
        Float f = 1.5f;//ok，自动装箱 Float.valueOf(1.5f);

        Object obj1 = true? new Integer(1) : new Double(2.0);
        //【三元运算符】 是一个整体，精度最高的是Double，所以会提升优先级，输出1.0
        System.out.println(obj1);

        Object obj2;
        if (true)
            obj2 = new Integer(1);//语句是独立的
        else
            obj2 = new Double(2.0);
        System.out.println(obj2);
        //if-else是分别独立的语句，不会提升精度，分别计算，不会提升优先级，输出1
    }
}
