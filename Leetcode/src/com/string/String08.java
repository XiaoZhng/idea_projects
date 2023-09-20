package com.string;

/**
 * @author Alonso
 */
public class String08 {
    /**
     * 外观数列
     *
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnpvdm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


    /**
     * 思路：
     * 需要用到递归
     * 1.先确定结束递归的操作
     * 2.使用 StringBuilder存放字符串
     * 3.设置计数器，和一个从第一个字符串开始比较的变量
     * 4.循环字符串，如果第一个数和第二个数相等，则计数器+1，继续用第一个数和第三个数比较，以此类推
     * 5.如果两数不相等，则把计数器中当前数存入到 StringBuilder中，紧接着存入当前的值 local，并重置计数器为1
     *   把下一个需要比价的数赋给 local
     * 6.当 str中所有数比较完后，把最后一个数加入StringBuilder中
     */
    public String countAndSay(int n) {
        //先确定递归出口
        if (n == 1){
            return "1";
        }

        String str = countAndSay(n - 1);
        StringBuilder s = new StringBuilder();
        //计数器，计算临近数相同的个数
        int count = 0;
        //从第一个数开始比较
        char local = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            //如果临近两个数相等，则计数器+1
            //第一次是 str中第一个数和自己比，所以count初始化为 0
            if (local == str.charAt(i)){
                count++;
            }else { //不相等
                s.append(count).append(local);
                //把计数器重置为1
                count = 1;
                //从不相等的数开始重新比较
                local = str.charAt(i);
            }
        }
        //把最后的数字加入
        s.append(count).append(local);
        return s.toString();
    }
}
