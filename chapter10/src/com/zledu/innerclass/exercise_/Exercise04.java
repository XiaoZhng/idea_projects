package com.zledu.innerclass.exercise_;

public class Exercise04 {
    public static void main(String[] args) {
        outher04 outher04 = new outher04();
        outher04.inner04 inner04 = outher04.m3();
        inner04.say();
        System.out.println("=================");
        outher04.inner04 inner04_ = new outher04.inner04();
        inner04_.say();

    }
}
class outher04{
    private static int n1 = 100;
    public static void hi(){
        System.out.println("outher04 hi()");
    }
    static class inner04{
        private int n1 = 999;
        public void say(){
            hi();
            System.out.println("n1=" + n1 + " n1=" + outher04.n1);
        }
    }
    public inner04 m3(){
        return new inner04();
    }

}