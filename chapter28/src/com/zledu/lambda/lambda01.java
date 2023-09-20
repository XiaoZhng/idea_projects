package com.zledu.lambda;

import java.util.Comparator;

/**
 * @author Alonso
 * 演示lambda表达式入门
 */
public class lambda01 {
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        };
        r1.run();

        System.out.println("=======使用lambda表达式=========");

        // ->：lambda操作符/箭头操作符
        Runnable r2 = () -> System.out.println("hi lambda");
        r2.run();

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(01, 02);
            }
        };
        int compare1 = com1.compare(1, 12);

        System.out.println(compare1);

        System.out.println("=======使用lambda表达式=========");

        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(21, 12);
        System.out.println(compare2);

        //方法引用 ::
        Comparator<Integer> com3 = Integer ::compare;
        int compare3 = com3.compare(21, 12);
        System.out.println(compare3);
    }
}
