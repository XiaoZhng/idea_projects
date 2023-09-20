package com.zledu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {

        int[] arr = {1, -2, 9, 5, -5};
        //bubble01(arr);

        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;//return i1 - i2;
            }
        });
        System.out.println(Arrays.toString(arr));

    }
    //冒泡排序
    public static void bubble01(int[] arr){
        int temp;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                //从小到大
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //结合冒泡 + 定制
    public static void bubble02(int[] arr, Comparator c){
        int temp;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                //数组的排序由 (c.compare(arr[j], arr[j+1])返回的值决定
                if (c.compare(arr[j], arr[j+1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
