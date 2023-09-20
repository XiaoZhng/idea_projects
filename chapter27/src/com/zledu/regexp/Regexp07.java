package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 分组
 */
public class Regexp07 {
    public static void main(String[] args) {

        String content = "hanf lfha6789nu hfgsdhfgh2345anhfjdshf";

        //非命名分组
        /**
         * 1.matcher.group(0) 得到匹配的字符串
         * 2.matcher.group(1) 得到匹配的字符串的第1个分组内容
         * 3.matcher.group(2) 得到匹配的字符串的第2个分组内容
         */
//        String regStr = "(\\d\\d)(\\d\\d)";//匹配4个数字的字符串

        //命名分组：即可以给分组取名
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";//匹配4个数字的字符串

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第1个分组内容：" + matcher.group(1));
            System.out.println("第1个分组内容[通过命名]：" + matcher.group("g1"));
            System.out.println("第2个分组内容：" + matcher.group(2));
            System.out.println("第2个分组内容[通过命名]：" + matcher.group("g2"));
        }
    }
}
