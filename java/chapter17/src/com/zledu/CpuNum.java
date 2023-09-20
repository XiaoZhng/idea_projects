package com.zledu;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的CPU数量
        int CpuNum = runtime.availableProcessors();

        System.out.println("Cpu个数=" + CpuNum);
    }
}
