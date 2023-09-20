package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * Matcher 的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {

        String content = "hello jack hello tom";
        String regStr = "hello";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("============");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到：" + content.substring(matcher.start(), matcher.end()));
        }

        //整体匹配方法，常用于，去检验某个字符串是否满足某个规则
        System.out.println("整体匹配= " + matcher.matches());

        //完成替换，将content中的hello 替换成 world
        //替换只会产生一个新的String对象，不会把原来的替换
        String newContent = matcher.replaceAll("world");
        System.out.println("newContent= " + newContent);
        System.out.println("content= " + content);
    }
}
