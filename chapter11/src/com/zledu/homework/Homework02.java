package com.zledu.homework;

public class Homework02 {
    public static void main(String[] args) {

    }
}

class Forck{
    private static int currentNum = 100000;//私有静态属性，
    private int serialNumber; //序列号

    public int getSerialNumber() {
        return serialNumber;
    }

    public Forck() {
        serialNumber = getNextNum();
    }

    public static int getNextNum(){
        //每调用一次则增加100
        return currentNum += 100;
    }
}

class TestFrock{
    public static void main(String[] args) {
        System.out.println(Forck.getNextNum());
        System.out.println(Forck.getNextNum());
        Forck forck1 = new Forck();
        Forck forck2 = new Forck();
        Forck forck3 = new Forck();
        System.out.println(forck1.getSerialNumber());
        System.out.println(forck2.getSerialNumber());
        System.out.println(forck3.getSerialNumber());
    }
}