package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示正则表达式的转义字符
 */
public class Regexp02 {
    public static void main(String[] args) {

        String content = "abc$(abc.(ab$c(";
        //匹配(
        //String regStr = "\\(";
        //匹配.
        String regStr = "\\.";
        //创建正则表达式对象
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
