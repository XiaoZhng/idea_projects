package com.zledu.regexp;

/**
 * @author Alonso
 * 替换、分割
 */
public class StringReg {
    public static void main(String[] args) {

        //替换
        //把 JDK1.3，JDK1.4 替换成 JDK
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，" +
                "几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，" +
                "J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，" +
                "与J2SE1.3相比，其多了近62%的类和接口。";
        content= content.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println(content);

        //验证手机号，要求138 139开头
        content = "13977996570";
        //matches是验证整体的，所以不用加定位符
        if (content.matches("1(38|39)\\d{8}")){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }


        //分割
        //按照 # - ~ 或者数字来分割
        System.out.println("=================");
        content = "hello#wor~ld-jack12ww";
        String[] split = content.split("#|-|~|\\d+");
        for (String s :split) {
            System.out.println(s);
        }

    }
}
