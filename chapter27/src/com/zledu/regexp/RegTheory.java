package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 分析java的正则表达式的底层实现(重要)
 */
public class RegTheory {
    public static void main(String[] args) {

        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，" +
                "几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日" +
                "，J2EE1.3发布。2002年2月26日，J2SE1.4发布。自此Java的计算能力" +
                "有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性" +
                "当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与" +
                "TLS协议）、全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J" +
                "2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要" +
                "性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，" +
                "Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、" +
                "基本类型的自动装箱、改进的循环、枚举类型、格式化I/O及可变参数。";

        //目标：匹配四个数字
        //说明：
        //1. \\d 表示一个人任意数字
        //String regexp = "\\d\\d\\d\\d";
        String regexp = "(\\d\\d)(\\d\\d)";//分组
        //2.创建模式对象[即正则表达式对象]
        Pattern compile = Pattern.compile(regexp);
        //3.创建匹配器
        //说明：创建匹配器matcher，按照 正则表达式的规则 去匹配 content字符串
        Matcher matcher = compile.matcher(content);

        /**
         * 阅读源码：
         * matcher.find() 完成的操作：
         * 1.根据指定的规则，定位满足规则(正则表达式规则)的子字符串(比如2000)
         * 2.找到后，将 子字符串的开始的索引记录到 matcher对象的属性 int[] groups;
         *      groups[0] = 0，把该子字符串的结束的索引+1的值记录到 groups[1] = 4
         * 3.同时记录 oldLast 的值为 子字符串的结束的 索引+1的值(即4)，即下次执行find()时，就从4开始匹配
         *
         * matcher.find() 完成的操作：考虑分组
         * 什么是分组，比如 (\d\d)(\d\d)，正则表达式中有()，表示分组，第1个()表示第1组，第2个()表示第2组，以此类推
         * 1.根据指定的规则，定位满足规则的子字符串(比如(20)(00))
         * 2.找到后，将 子字符串的开始的索引记录到 matcher对象的属性 int[] groups;
         *  2.1 groups[0] = 0, 把该子字符串的结束的索引+1的值记录到 groups[1] = 4
         *  2.2 记录第1组()匹配到的字符串 groups[2] = 0, groups[3] = 2
         *  2.3 记录第2组()匹配到的字符串 groups[4] = 2, groups[5] = 4
         *  2.4 如果有更多分组，以此类推...
         *
         * matcher.group(0) 分析：
         *
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         * 1.根据 groups[0] = 0 和 groups[1] = 4 的记录的位置，从content开始截取字符串返回就是 [0,4)
         *      包含 0 但是不包含 4 的位置
         *
         *  如果再次指向 find()，仍然按照上面的方式下                                                              执行
         */

        //4.开始匹配
        while (matcher.find()){
            //小结：
            //1.如果正则表达式有() 即表示分组
            //2.取出匹配的字符串规则如下
            //group(0) 表示匹配到的子字符串
            //group(1) 表示匹配到的子字符串的第1组字符
            //group(2) 表示匹配到的子字符串的第2组字符
            //以此类推，但是分组的数不能越界
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第1组()匹配的值= " + matcher.group(1));
            System.out.println("第2组()匹配的值= " + matcher.group(2));
            //System.out.println("第3组()匹配的值= " + matcher.group(3));//数组越界异常
        }
    }
}
