package com.zledu.innerclass.exercise_;

public class Exercise02 {
    public static void main(String[] args) {
        phone phone = new phone();
        phone.clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了...");
            }
        });
        phone.clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了...");
            }
        });
    }
}

interface Bell{
    void ring();
}
class phone{
    public void clock(Bell bell){
        bell.ring();
    }
}