package com.zledu.regexp;

import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示 matches方法，用于整体匹配，在验证输入的字符串是否满足条件使用
 */
public class PatternMethod {
    public static void main(String[] args) {

        String content = "hello jack hello tom";
        String regStr = "hello";

        boolean matches = Pattern.matches(regStr, content);
        System.out.println("是否符合匹配= " + matches);
    }
}
