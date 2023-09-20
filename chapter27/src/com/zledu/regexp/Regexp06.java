package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示 定位符 的使用
 */
public class Regexp06 {
    public static void main(String[] args) {

//        String content = "123abc";
//        String regStr = "^[0-9]+[a-z]*";//表示至少有一个数字开头，后接 零到多个 小写字母的字符串

//        String content = "12-abc";
//        String regStr = "^[0-9]+[a-z]+$";//表示至少有一个数字开头，后接 一到多个 小写字母结尾 的字符串
//        String regStr = "^[0-9]+\\-[a-z]+$";//表示至少有一个数字开头，后接 一到多个 小写字母结尾，数字与字母之间是 - 的字符串

        //表示匹配目标字符串的边界 [边界：被匹配的字符串在最后，空格也算边界]
        String content = "hanf sfhan lfhanu hfgsdhfghanhfjdshf";
//        String regStr = "han\\b";//和 \\b 相反，不在边界的都算
        String regStr = "han\\B";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
