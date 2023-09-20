package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示字符匹配符的使用
 */
public class Regexp03 {
    public static void main(String[] args) {

        String content = "allvS67G d1_AL L@";
        //String regStr = "[a-z]";//匹配a-z之间任意一个字符
        //String regStr = "[A-Z]";//匹配A-Z之间任意一个字符
        //String regStr = "all";//匹配 all 字符串[默认区分大小写]
        //String regStr = "(?i)all";//匹配 all 字符串[不区分大小写]
        //String regStr = "[0-9]";//匹配0-9之间任意一个字符
        //String regStr = "[^a-z]";//匹配不在 a-z之间任意一个字符
        //String regStr = "[^0-9]";//匹配不在 0-9之间任意一个字符
        //String regStr = "[abcd]";//匹配在 abcd 中任意一个字符
        //String regStr = "\\D";//匹配不在 0-9之间任意一个字符
        //String regStr = "\\w";//匹配任意 字母，数字，下划线
        //String regStr = "\\W";//匹配 等价于 [^a-zA-Z0-9]
        //String regStr = "\\s";//匹配任何空白字符(空格、制表符等)
        //String regStr = "\\S";//匹配 任何非空白字符，和\\s相反
        String regStr = ".";//匹配\n之外的所有字符，如果要匹配.本身需要使用\\.

        //说明：
        //1.当创建 Pattern对象时，指定 Pattern.CASE_INSENSITIVE。表示匹配是不区分字母大小写
        //Pattern compile = Pattern.compile(regStr);
        Pattern compile = Pattern.compile(regStr/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
