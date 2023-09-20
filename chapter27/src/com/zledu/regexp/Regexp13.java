package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 */
public class Regexp13 {
    public static void main(String[] args) {

        String content = "我...我要要...学java";

        //1.去掉所有的.
        String regStr = "\\.";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        String con = matcher.replaceAll("");
        System.out.println(con);

        //2.去掉重复字 我我要要学java
        //1.使用(.)\\1+： (.) 表示匹配全部，然后反向引用(后面的字符和前面的相同) +：一到多
        //2.使用反向引用$1 来替换匹配到的内容
        // "$1" 表示选中 "(.)\\1+" 中第一个字符，来替换后面和它重复的字符

        //因为正则表达式变化，所以要重置 matcher
        pattern = Pattern.compile("(.)\\1+");
        matcher = pattern.matcher(con);
        //$1 是 外部反向引用
        String con2 = matcher.replaceAll("$1");
        System.out.println("con2= " + con2);

        //3.使用一条语句去掉重复的字(前提先去掉.)
        String newContent = Pattern.compile("(.)\\1+").matcher(con).replaceAll("$1");
        System.out.println("newContent= " + newContent);
    }
}
