package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示正则表达式的使用 (URL地址)
 */
public class Regexp11 {
    public static void main(String[] args) {

        //String content = "10https://fanyi.baidu.com/translate?aldtype=16047&query=as+if&keyfrom=baidu&smartresult=dict&lang=auto2zh#en/zh/as%20if";
        String content = "&www.neotechnology.cn/footballmaster/PL.aspx?pid=5";

        /**
         * 思路：
         * 1.先确定 url 的开始部分 https:// 和 http://
         * 2.然后通过 ([\\w-]+\\.)+[\\w-]+ 匹配 fanyi.baidu.com
         * 3. ? 限定符，表示可以有也可以没有
         */
        //注意：[.]表示匹配就是 .本身
        String regStr = "((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?&%#=./+]*)?";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        }else {
            System.out.println("不满足格式");
        }

        //使用 Pattern.matches 来匹配
        //String regStr = "((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?&%#=./+]*)?";
        //使用 Pattern.matches 来匹配，正则表达式可以去掉定位符，因为是 匹配整体
        System.out.println(Pattern.matches(regStr, content));
    }
}
