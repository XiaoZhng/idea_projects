package com.zledu.exception_;

//数组下标越界异常
public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        for (int i = 0; i <= arr.length; i++) { //ArrayIndexOutOfBoundsException 数组下标越界异常
//            System.out.println(arr[i]);
//        }
        int sum = 10;
        ++sum;
        System.out.println(sum);//11
    }
}
