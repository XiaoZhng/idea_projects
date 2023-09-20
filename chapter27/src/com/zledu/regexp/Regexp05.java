package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示 限定符 的使用
 */
public class Regexp05 {
    public static void main(String[] args) {

        String content = "a111111aaaaahello";
//        String regStr = "a{3}";//表示匹配 aaa，等价于 "aaa"
//        String regStr = "1{3}";//表示匹配 111，等价于 "111"
//        String regStr = "\\d{2}";//表示匹配 两位的任意数字字符

        //细节：java匹配默认是贪婪匹配，即尽可能匹配多的
//        String regStr = "a{3,4}";//表示匹配 aaa 或者 aaaa
//        String regStr = "1{4,5}";//表示匹配 1111 或者 11111
//        String regStr = "\\d{2,4}";//表示匹配任意数字 二位、三位、四位

        //1+
//        String regStr = "1+";//表示匹配一个1或多个1
//        String regStr = "\\d+";//表示匹配一个数字或多个数字

        //1*
        //String regStr = "1*";//表示匹配零个1或多个1

        //演示 ? 使用：要么出现0次，要么出现1次
        String regStr = "a1?";//表示匹配 a 或者 a1

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
