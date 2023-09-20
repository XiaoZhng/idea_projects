package com.zledu.arrays_;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        /**
         * binarySearch 通过二分搜索法进行查找，要求必须排序好
         * 解读：
         * 1.使用binarySearch 二叉查找
         * 2.要求该数组是有序的，如果该数组是无序的，不能使用binarySearch
         * 3.如果数组中不存在该元素，就返回 return -(low + 1); key not found.
         */
        int index = Arrays.binarySearch(arr,7);
        System.out.println("index=" + index);

        //copyOf 数组元素的复制
        //1.从 arr数组中，拷贝 arr.length个元素到 newArr数组中
        //2.如果拷贝的长度 > arr.length 就在新数组的后面 增加 null
        //3.如果拷贝长度 <0 就抛出异常 NegativeArraySizeException
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));

        //fill 数组元素的填充
        Integer[] num = new Integer[]{9,8,7};
        //int[] num1 = {1,1};
        //使用 99 去填充 num数组，可以理解成替换原来的元素
        Arrays.fill(num, 99);
        System.out.println(Arrays.toString(num));

        //equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1,2,3,4,5,5};
        //如果arr 和 arr2 数组的元素一样，则返回true，不完全一样返回false
        System.out.println(Arrays.equals(arr, arr2));

        //asList 将一组值，替换成List
        //1.asList方法，会将(2,3,4,5,6,1)数据转成一个List集合
        //2.返回的 asList 编译类型 List(接口)
        //3.asList 运行类型 java.util.Arrays$ArrayList，是Arrays类的
        //  静态内部类 private static class ArrayList<E> extends AbstractList<E>
        //        implements RandomAccess, java.io.Serializable
        List asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList=" + asList);
        System.out.println("asList的运行类型=" + asList.getClass());
    }
}
