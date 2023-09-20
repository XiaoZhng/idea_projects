package com.zledu.homework;

public class Homework03 {
    public static void main(String[] args) {

        String name = "Han Shun Ping";
        name(name);
    }
    public static void name(String str){

        if (str == null){
            System.out.println("不能为null");
            return;
        }
        String[] s = str.split(" ");
        //判断数组的长度是否为3
        if (s.length != 3){
            System.out.println("字符串输入不正确");
            return;
        }
        //调用String.format()格式化
        String format = String.format("%s,%s.%c", s[2], s[0], s[1].toUpperCase().charAt(0));
        System.out.println(format);
    }

    /**
     * 输入形式：Han Shun Ping的人名，以 Ping,Han.S的形式打印出来
     * 其中.S 是中间单词的首字母
     *
     * 思路分析：
     * (1) 先用str.split(" ");按空格进行分割，得到数组
     * (2) 再用String.format()格式化即可
     */
}
