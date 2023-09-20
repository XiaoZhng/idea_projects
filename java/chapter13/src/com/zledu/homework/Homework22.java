package com.zledu.homework;

public class Homework22 {
    public static void main(String[] args) {
        String str = "123@cccom";
        //System.out.println(str.indexOf('.'));

        String name = "jack";
        String pwd = "123456";
        String email = "123@tt.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("注册成功...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 改进：写在方法中判断
     * 输入用户名，密码，邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
     * 要求：(1) 用户名长度为2或3或4 (2) 密码长度为为6，要求全是数字 (3) 邮箱中包含@和. 并且@在.的前面
     *
     * 思路分析：
     * (1) 编写方法userRegister，把三个参数放入方法中进行校验，如果发生问题，就抛出异常，给出提示
     */

    public static void userRegister(String name, String pwd, String email) {

        //过关斩将

        if (!(name != null && pwd != null && email != null)){
            throw new RuntimeException("不能为null");
        }

        //第一关：判断name
        int length = name.length();
        if (!(length >= 2 && length <= 4)) {
            throw new RuntimeException("用户名长度为2或3或4");
        }

        //第二关：判断pwd
        int pwdLen = pwd.length();
        if (!(pwdLen == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码长度为为6，要求全是数字");
        }

        //第三关：判断email
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && i < j)){
            throw new RuntimeException("邮箱中包含@和. 并且@在.的前面");
        }

    }

    public static boolean isDigital(String pwd) {
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
