package com.zledu.innerclass.exercise_;

public class Exercise03 {
    public static void main(String[] args) {
        outher03 outher03 = new outher03();
        outher03.m1();
        System.out.println("================");
        outher03.inner03 inner03 = outher03.new inner03();
        inner03.hi();
        System.out.println("================");
        outher03.inner03 inner03_ = outher03.m2();
        inner03_.hi();
    }
}

class outher03{
    private int n1 = 10;
    public void say(){
        System.out.println("outher03 say()");
    }
    class inner03{//成员内部类
        private int n1 = 99;
        public void hi(){
            System.out.println("hello...");
            System.out.println("n1=" + n1 + " n1=" + outher03.this.n1);
            say();
        }
    }

    public void m1() {
        inner03 inner03 = new inner03();
        inner03.hi();
    }
    public inner03 m2(){
        return new inner03();
    }
}