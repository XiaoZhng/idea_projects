package com.zledu.interFace_;

public class InterfaceExercise02 {
    public static void main(String[] args) {
        new C().pp();
    }
}

interface A01{
    int x = 0; //等价于 public static final int x = 0;
}
class B{
    int x = 1;
}
class C extends B implements A01{
    public void pp(){
        //System.out.println(x);
        /**
         * 可以明确的执行x
         * 访问接口的x就用 A01.x
         * 访问父类的x就用 super.x
         */
        System.out.println("A01接口中的x=" + A01.x + " 父类B中的x=" + super.x);
    }
}