package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示 非捕获分组，语法比较奇怪
 */
public class Regexp08 {
    public static void main(String[] args) {

        String content = "11hijack 22hitom 33hilucy";
//        String regStr = "hijack|hitom|hilucy";

        //上面的写法等价于 非捕获分组，注意：不能 matcher.group(1)
        //找到 hijack、hitom、hilucy
//        String regStr = "hi(?:jack|tom|lucy)";

        //找到 hi 关键字，但是要求只是查找 hijack 和 hitom 中包含的 hi
        //下面也是非捕获分组，不能 matcher.group(1)
//        String regStr = "hi(?=jack|tom)";

        //找到 hi 关键字，但是要求只是查找 不是 (hijack 和 hitom) 中包含的 hi
        //下面也是非捕获分组，不能 matcher.group(1)
        String regStr = "hi(?!jack|tom)";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
