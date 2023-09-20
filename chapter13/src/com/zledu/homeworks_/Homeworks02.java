package com.zledu.homeworks_;

import java.util.Scanner;

public class Homeworks02 {
    public static void main(String[] args) {
        /**
           验证用户名，密码，邮箱是否正确，不正确就抛出异常
           用户名长度为2-4
           密码长度为6，全是数字
           邮箱包含@和.，并且@在.的前面
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名：");
        String name = scanner.next();
        System.out.print("密码：");
        String pw = scanner.next();
        System.out.print("邮箱：");
        String email = scanner.next();

        try {
            check(name, pw, email);
            System.out.println("注册成功...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void check(String name, String pw, String email){

        if (!(name.length() >= 2 && name.length() <= 4)){
            throw new RuntimeException("用户名长度不正确...");
        }

        if (!(pw.length() == 6)){
            throw new RuntimeException("密码长度不正确...");
        }

        try {
            Integer.parseInt(pw);
        } catch (NumberFormatException e) {
            System.out.println("密码不正确...");
        }

        int i = email.indexOf("@");
        int j = email.indexOf(".");
        if (i > j && i != -1 && j != -1){
            throw new RuntimeException("邮箱格式不正确...");
        }

    }
}
