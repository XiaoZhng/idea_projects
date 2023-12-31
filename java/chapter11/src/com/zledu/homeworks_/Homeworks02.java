package com.zledu.homeworks_;

public class Homeworks02 {
    public static void main(String[] args) {
        System.out.println("序列号:" + Frock.getNextNum());
        System.out.println("序列号:" + Frock.getNextNum());
        System.out.println("===========================");

        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
        System.out.println(frock3.getSerialNumber());
    }
}

class Frock{
    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }
}