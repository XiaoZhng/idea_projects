package com.zledu.exercise_;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {

        //用户输入一个数，判断是不是整数，如果不是就反复输入，知道正确为止
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("请输入一个整数：");
                String str = scanner.next();
                int num = Integer.parseInt(str);//输入的不是整数就会抛出异常，转换异常，下面语句将不执行
                System.out.println("整数为：" + num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的不是整数，请重新输入！");//捕获异常
                //System.out.println(e.getMessage());
            }
        }
    }
}
