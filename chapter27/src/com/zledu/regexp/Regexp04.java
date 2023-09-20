package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 演示 选择匹配符 的使用
 */
public class Regexp04 {
    public static void main(String[] args) {

        String content = "hanleng 寒冷 喊叫";
        String regStr = "han|寒|喊";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
