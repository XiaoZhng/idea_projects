package com.zledu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallchangeSys {

    //化繁为简
    //1.先完成显示菜单那，并选择菜单，给出对应提示
    //2.完成零钱通明细
    //3.收益入账
    //4.消费
    //5.退出
    //6.用户输入4退出时，给出提示“你确定要退出吗？y/n”，必须输入正确的y/n，否则循环输入指令，直到输入y或者n
    //7.在收益入账和消费时，判断金额是否合理，并给出对应的提示

    public static void main(String[] args) {
        //定义相关变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细
        //思路:(1) 可以把收益入账和消费，保存到数组 (2) 可以使用对象 (3) 简单的话可以使用String拼接
        String detail = "------零钱通明细------";

        //3.收益入账
        double money = 0; //收益
        double balance = 0; //余额
        Date date = null; // date 是 java.util.Date 类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化

        //4.消费
        //定义新变量，保存消费的原因和金额
        String spend = "";
//        double unmoney = 0; //消费
        do {

            System.out.println("\n======零钱通菜单======");
            System.out.println("\t1.零钱通明细");
            System.out.println("\t2.收益入账");
            System.out.println("\t3.消费");
            System.out.println("\t4.退出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            //使用switch分支控制
            switch (key){
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.println("收益入账金额:");
                    money = scanner.nextDouble();
                    //money范围校验
                    //思路，编程思想
                    //找出不正确的金额条件，然后给出提示，就直接break
                    if(money <= 0){
                        System.out.println("收益金额需要大于0");
                        break;
                    }

                    balance += money;
                    //拼接收益入账到 detail
                    date = new Date(); //获取当前日期
                    detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额" + balance;
//                  System.out.println(sdf.format(date));
                    break;
                case "3":
                    System.out.println("消费说明:");
                    spend = scanner.next();
                    System.out.println("消费金额:");
                    money = scanner.nextDouble();
                    //money范围校验
                    //找出金额不正确的情况
                    if(money <=0 || money > balance){
                        System.out.println("消费金额应在0-" + balance);
                        break;
                    }
                    balance -= money;
                    //拼接消费信息到 detail
                    date = new Date(); //获取当前日期
                    detail += "\n" + spend + "\t\t-" + money + "\t" + sdf.format(date) + "\t余额" + balance;
//                    unmoney = scanner.nextDouble();
//                    balance -= unmoney;
//                    detail += "\n" + spend + "\t\t-" + unmoney + "\t" + sdf.format(date) + "\t余额" + balance;
                    break;
                case "4":
                    //6.用户输入4退出时，给出提示“你确定要退出吗？y/n”，必须输入正确的y/n，
                    // 否则循环输入指令，直到输入y或者n
                    //思路分析：
                    //(1) 定义一个变量 choice，接收用户的输入
                    //(2) 使用while + break，来处理接收到的输入时 y 或者 n
                    //(3) 退出while后，再判断choice是y还是n，就可以决定是否退出
                    //(4)* 建议一段代码，完成一个小功能，尽量不要混在一起

                    String choice = "";
                    while (true){ //要求用户必须输入y/n，否则就一直循环
                        System.out.println("你确定要退出吗？y/n");
                        choice = scanner.next();
                        if (choice.equals("y") || choice.equals("n")){
                            break;
                        }
                    };
                    //当用户退出while时，进行判断
                    if (choice.equals("y")) {
                        loop = false;
                        break;
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
            }

        }while (loop);
        System.out.println("零钱通程序退出！");
    }
}
