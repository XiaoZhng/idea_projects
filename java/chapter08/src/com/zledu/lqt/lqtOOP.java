package com.zledu.lqt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class lqtOOP {
    public static void main(String[] args) {

        //化繁为简
        /*
        1.基本页面显示,并选择功能
        2.零钱通明细
        3.收益入账
        4.消费
        5.退出
        6.对收益入账和消费进行校验
         */

        //定义变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = ""; //接收用户输入的选择

        //2.零钱通明细
        String detail = "------零钱通明细------";

        //3.收益入账
        double money = 0;//收益
        double balance = 0;//余额
        Date date = null;//日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");

        //4.消费
        String span = "";//消费项目

        //5.退出
        String end = "";//接收用户输入的y/n

        do {
            System.out.println("-----零钱通菜单-----");
            System.out.println("1.零钱通明细");
            System.out.println("2.收益入账");
            System.out.println("3.消费");
            System.out.println("4.退出");

            System.out.print("请选择(1-4):");
            key = scanner.next();

            //用switch语句控制用户输入的结果，并显示功能
            switch (key) {
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.print("收益金额：");
                    money = scanner.nextDouble();//money接收用户输入的收益金额
                    //校验：找不正确的条件，给出提示，直接break
                    if (money <= 0){
                        System.out.println("收益入账金额的范围需要大于0");
                        break;
                    }
                    date = new Date();//获取时间
                    balance += money;//余额=余额+收益
                    detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                case "3":
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();//接收用户输入的消费金额
                    //校验：找不正确的条件，给出提示，直接break
                    if (money <= 0 || money > balance){
                        System.out.println("消费金额的范围应在0-" + balance);
                        break;
                    }
                    System.out.println("消费项目：");
                    span = scanner.next();//接收用户输入的消费项目
                    balance -= balance - money;//余额=余额-消费
                    date = new Date();//获取时间
                    detail += "\n" + span + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                case "4":
                    while (true){
                        System.out.println("你确定要退出吗？y/n");
                        end = scanner.next();
                        if (end.equals("y") || end.equals("n")){
                            //如果用户输入y或n则直接退出当前循环
                            break;
                        }
                    }
                    //当退出循环后，再进一步判断输入的是y还是n，如果是y则退出程序，
                    if (end.equals("y")){
                        loop = false;
                        break;
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
            }


        } while (loop);
        System.out.println("程序退出！");
    }
}
