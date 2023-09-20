package com.zledu.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 */
public class Homework03 {
    /**
     * 对 url进行解析
     * http://www.baidu.com:8080/abc/index.html
     * 协议：http
     * 域名：www.baidu.com
     * 端口：8080
     * 文件名：index.html
     */
    public static void main(String[] args) {

        String content = "http://www.baidu.com:8080/abc/index.html";
        String regStr = "^([a-zA-Z]*)://([a-zA-Z.-]+):(\\d+)/[\\w-/]*/([\\w.]+)$";

        //^([a-zA-Z]*)://([a-zA-Z.-]+):(\\d+)/[\\w-/]*/([\\w.]+)$
        /**
         * ([a-zA-Z]*)：协议大小写字母可有可无
         * ://：分隔符
         * ([a-zA-Z.-]+)：域名大小写字母加.-，必须有一个，一到多
         * :：分隔符
         * (\\d+)：端口：数字，一到多
         * /：分隔符
         * [\\w-/]*：路径，任意字母数字下划线和 / ，可有可无
         * /：分隔符
         * ([\\w.]+)：文件名：任意字母数字下划线和 . ，一到多
         */

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches()){
            System.out.println("整体匹配= " + matcher.group(0));
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(3));
            System.out.println("文件名：" + matcher.group(4));
        }else {
            System.out.println("匹配失败");
        }
    }
}
