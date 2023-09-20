package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 反向引用
 */
public class Regexp12 {
    public static void main(String[] args) {

        String content = "hello12321-666777888 12345-112233jack11 hello33333 tom5225";
        //要匹配连续两个相同的数字
        //String regStr = "(\\d)\\1";

        //要匹配连续五个相同的数字
        //String regStr = "(\\d)\\1{4}";

        //要匹配个位与千位相同，十位与百位相同的数，比如：5225 2332
        //String regStr = "(\\d)(\\d)\\2\\1";

        //在字符串中检索商品编号，比如：12321-666777888
        //要求前面是一个五位数，然后一个 -号，然后是一个九位数，连续的每三位相同
        //注意：(\\d)\\1 等价于 (\\d)\\1{1}，后面写{?}包括前面的反向引用
        String regStr = "\\d{5}-(\\d)\\1\\1(\\d)\\2\\2(\\d)\\3\\3";
        //String regStr = "\\d{5}-(\\d)\\1{1}(\\d)\\2{1}(\\d)\\3{1}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
