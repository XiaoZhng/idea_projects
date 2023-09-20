package com.zledu.homework;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("用户名：");
            String name = scanner.next();
            if (!(name.length() > 1 && name.length() < 5)){
                throw new RuntimeException("用户名长度为2或3或4");
            }
            System.out.print("密码：");
            String pwd = scanner.next();
            if (!(pwd.length() == 6 && isDigital(pwd))){
                throw new RuntimeException("密码长度为为6，要求全是数字");
            }

            System.out.print("邮箱：");
            String email = scanner.next();
            int i = email.indexOf('@');
            int j = email.indexOf('.');
            if (!(i > 0 && i < j)){
                throw new RuntimeException("邮箱中包含@和. 并且@在.的前面");
            }
            System.out.println("注册成功...");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static boolean isDigital(String pwd){
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9'){ // ||或者  &&并且
                return false;
            }
        }
        return true;
    }
    /**
     * 输入用户名，密码，邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
     * 要求：(1) 用户名长度为2或3或4 (2) 密码长度为为6，要求全是数字 (3) 邮箱中包含@和. 并且@在.的前面
     */
}
