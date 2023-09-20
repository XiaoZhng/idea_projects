package com.zledu.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        /**
         * 1.传递的是实现了 Bell接口的匿名内部类
         * 2.重写了 ring方法
         * 3.Bell bell = new Bell() {
         *             @Override
         *             public void ring() {
         *                 System.out.println("懒猪起床了...");
         *             }
         *         }
         */
        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("懒猪起床了...");
            }
        });
        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("小伙伴上课了...");
            }
        });
    }
}

//铃声接口
interface Bell{
    void ring();
}
class CellPhone{ //闹钟功能
    public void alarmClock(Bell bell){ //形参是接口类型
        bell.ring();
    }
}