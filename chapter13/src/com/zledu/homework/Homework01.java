package com.zledu.homework;

public class Homework01 {
    public static void main(String[] args) {

        String str = "abcdef";
        System.out.println("交换前-");
        System.out.println(str);
        try {
            str = reverse(str, 0, 4);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            return;
        }
        //str = reverse(str, 1, 4);
        System.out.println("交换后-");
        System.out.println(str);
    }

    /**
     * 将字符串中指定部分进行反转。比如 "abcdef" 反转为 "aedcbf"
     * 编写方法 public static String reverse(String str, int start, int end)完成
     *
     * 思路分析：
     * (1) 编写方法
     * (2) 把 String 转成 char[]数组，因为String是final类，不能修改本身的值，char[]从元素可以转换
     */
    public static String reverse(String str, int start, int end) {

        //对输入进行验证
        //重要编程技巧！！！
        //(1) 写出正确的情况 (正确情况容易想到)
        //(2) 然后取反即可

//        if (!(str != null && start >= 0 && start < end && end < str.length())){
//            throw new RuntimeException();
//        }
        if (str == null){
            throw new NullPointerException("null异常...");
        }
        if (!(start >= 0)){
            throw new ArithmeticException("开始位置不正确...");
        }
        if (!(start < end)){
            throw new ArithmeticException("开始位置大于结束位置...");
        }
        if (!(end < str.length())){
            throw new ArrayIndexOutOfBoundsException("结束位置大于字符串长度...");
        }

        char[] chars = str.toCharArray();//toCharArray可以把 str转换成 char[]
        //创建i，j分别表示开始位置和结束位置，开始位置大于结束位置则表示交换结束
        // i++表示开始坐标每交换一次就往后移动一次，j--表示结束坐标每交换一次就往前移动一次
        char temp;//交换辅助变量
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //使用chars 重新构建一个String 返回即可
        return new String(chars);
    }
}
