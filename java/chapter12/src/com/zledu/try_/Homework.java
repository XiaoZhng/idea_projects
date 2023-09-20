package com.zledu.try_;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        /**
         * 思路：
         * 1.先创建Scanner 接收用户输入
         * 2.用一个int类型的变量接收转换
         * 3.把用户输入的字符串转换成int
         * 4.用无限循环来判断是否为整数，不是则反复循环
         */
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            System.out.print("请输入一个整数：");
            String str = scanner.next();
            try {
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                //catch捕获异常，try发生异常就停止执行后续代码，直接执行catch
                System.out.println("输入的不是整数...");
            }
        }
        System.out.println("输入的整数是：" + num);

    }
}
