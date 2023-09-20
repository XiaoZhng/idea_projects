package com.zledu.stringbuffer_.exercise_;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        /**
         * 1.接收用户输入的价格，把价格添加入 StringBuffer
         * 2.把价格进行遍历
         * 3.先获取到小数点的位置，再从小数点位置往前遍历，每三前移三位就加逗号 insert()
         */
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("输入商品价格：");
//        String price = scanner.next();
        String price = "94575123.12";
        StringBuffer sb = new StringBuffer(price);
        //先完成个简单的
        //获取小数点的位置
        int s = sb.lastIndexOf(".");
//        sb.insert(s-3, ",");//小数点的位置前移三位再加","

        //insert() + for循环
        //int i = s; 循环起始点从小数点的位置开始
        //i > 0; 设置范围，当i < 0时，就说明已经到第一个数了，就结束循环
        //i-=3; 每前移三位就执行命令
        for (int i = s - 3; i > 0; i-=3){ //先-3判断是否大于0，满足就插入，然后继续-3再判断是否大于0，满足就插入，依此类推
            sb.insert(i, ",");
        }
//        for (int i = 0; i < 0; i++){
//
//        }
        System.out.println(sb);

    }
}
