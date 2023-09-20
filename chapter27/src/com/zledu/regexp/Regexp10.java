package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 正则表达式的应用
 */
public class Regexp10 {
    public static void main(String[] args) {

        String content = "18987657659";
        //汉字
//        String regStr = "^[\u0391-\uffe5]+$";

        //邮政编码
        //要求：是1-9开头的六位数，比如 123890
//        String regStr = "^[1-9]\\d{5}$";

        //QQ号码
        //要求：是1-9开头的(5位数到10位数)，比如 12345 123456 1234567899
//        String regStr = "^[1-9]\\d{4,9}$";

        //手机号码
        //要求：必须以13，14，15，18开头的11位数，比如 13987657659
        String regStr = "^1[3|4|5|8]\\d{9}$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        }else {
            System.out.println("不满足格式");
        }
    }
}
