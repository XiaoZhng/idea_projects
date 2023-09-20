package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示 非贪婪匹配
 */
public class Regexp09 {
    public static void main(String[] args) {

            String content = "a111111aaaaahello";
    //        String regStr = "\\d+";//表示匹配 一个或多个数字 默认贪婪匹配
            String regStr = "\\d+?";//表示匹配 一个或多个数字 非贪婪匹配
            Pattern compile = Pattern.compile(regStr);
            Matcher matcher = compile.matcher(content);

            while (matcher.find()){
                System.out.println("找到：" + matcher.group(0));
            }

    }
}
