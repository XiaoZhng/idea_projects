package com.zledu.homework;

/**
 * @author Alonso
 */
public class Homework01 {
    /*
        验证电子邮箱
        1.只能有一个 @
        2.@前面是用户名，可以是a-z A-Z 0-9 _-字符
        3.@后面是域名，域名只能是英文字母，比如 souhu.com baidu.org.cn
        4.写出正则表达式，并验证
     */
    public static void main(String[] args) {
        String content = "user@qq.aa.cc.com";
        // . 写在[]里就表示 . 写在()里表示全部，要是想表示.就写成 \\.
        // 正则表达式也可以写成 "[\\w-]+@([a-zA-Z]+.)+[a-zA-Z]+"
        // 虽然是整体匹配，严谨点加上定位符
        if (content.matches("^[a-zA-z0-9_-]+@[a-zA-Z.]+[a-zA-Z]+$")){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }

        /**
         * 阅读 matches 源码：
         * 尝试将整个区域与模式匹配
         * Attempts to match the entire region against the pattern.
         *
         * String 的 matches：
         * public boolean matches(String regex) {
         *         return Pattern.matches(regex, this);
         *     }
         *
         *  Pattern 的 matches：
         *     public static boolean matches(String regex, CharSequence input) {
         *         Pattern p = Pattern.compile(regex);
         *         Matcher m = p.matcher(input);
         *         return m.matches();
         *     }
         *
         *  Matcher 的 matches：
         *     public boolean matches() {
         *         return match(from, ENDANCHOR);
         *     }
         */
    }

}
