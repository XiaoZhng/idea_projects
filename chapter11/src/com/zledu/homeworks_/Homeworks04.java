package com.zledu.homeworks_;

public class Homeworks04 {
    public static void main(String[] args) {
        cellphone cellphone = new cellphone();
        cellphone.testWork(new compter() {
            @Override
            public int work(int n1, int n2) {
                return n1 + n2;
            }
        }, 2, 3);

        cellphone.testWork(new compter() {
            @Override
            public int work(int n1, int n2) {
                return n1 * n2;
            }
        }, 2, 3);
    }
}
interface compter{
    int work(int n1, int n2);
}
class cellphone{
    public void testWork(compter compter, int n1, int n2){
        int result = compter.work(n1, n2);
        System.out.println("计算结果=" + result);
    }
}