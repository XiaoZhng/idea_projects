package com.zledu.stringbuffer_;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /**
         * 输出效果：
         * 商品名      商品价格
         * 手机         123,456.78
         * 要求：价格的小数点前面每三位用逗号隔开，再输出
         *
         * 自己思路分析：
         * 1.接收用户输入的商品名和价格
         * 2.把价格用插入的方法 insert(3, ",")间隔
         * 3.输出商品名和价格
         */

        String price = "1123456.78";
        //String 的价格转换成 StringBuffer 才能调用 insert()
        StringBuffer sb = new StringBuffer(price);
        //要求：价格的小数点前面每三位用逗号隔开，再输出
        //先找放到小数点的位置，因为是从后面开始找所以用lastIndexOf()
        //int i = sb.lastIndexOf(".");
        //获取到小数点的位置后，就可以调用 insert() 插入即可
        //先完成一个简单的实现 123,456.78
        //i - 3 小数点前面每三位
        //sb = sb.insert(i - 3, ",");
//        System.out.println(sb);//123,456.78

        //考虑到价格位数更多的情况，所以需要用到循环
        //int i = sb.lastIndexOf(".") - 3; 按需求分析得出 循环的初始值就是 小数点的位置-3开始循环
        //i > 0; 找到-3的位置后，再判断是否大于0
        //i -= 3; 每-3次就插入一个 ","
        //sb = sb.insert(i, ","); 循环已经-3了，插入就不要再减了
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3){
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);
    }
}
