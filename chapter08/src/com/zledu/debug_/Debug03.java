package com.zledu.debug_;

import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2};
        //看看Arrays.sort方法底层实现->Debug
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
