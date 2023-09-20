package com.zledu.customexception_.homework;

public class Homework01 {
    public static void main(String[] args) {
        /**
         * 1.编写EcmDef.java，接收命令行的两个整数，计算两数相除
         * 2.计算两数相除，要求使用方法cal(int n1, int n2)
         * 3.对数据格式不正确(NumberFormatException)，
         * 缺少命令行参数(ArrayIndexOutOfBoundsException)，
         * 除0(AirthmeticException) 进行异常处理
         */

        /**
         * 思路:
         * 1.从输入来判断，是否缺少参数
         * 2.因为main方法是字符串数组，所以要把字符串类型转换成int
         * 3.判断除0情况
         * 4.如果没有异常，输出结果
         */

        try {
            if (args.length != 2){
                throw new ArrayIndexOutOfBoundsException("缺少命令行参数...");//缺少参数异常
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);//数字格式类型转换异常

            double res = cal(n1, n2);//除0异常

            System.out.println("计算结果= " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确...");
        } catch (ArithmeticException e){
            System.out.println("有除0情况...");
        }
    }

    public static double cal(int n1, int n2){
        return n1 / n2;
    }
}
