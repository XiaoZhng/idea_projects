package com.zledu.date_;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {

        //第二代日期类

        //1.Calendar 是一个抽象类，并且构造器是private
        //2.可以通过 getInstance() 来获取实例
        //3.提供大量的方法和字段提供给程序员
        //4.Calendar 没有专门的格式化方法，所以需要程序员直接来组合显示(灵活)
        //5.如果要按照24小时进制 Calendar.HOUR -> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance();//创建日历对象
        System.out.println("c = " + c);

        //获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        //为什么要 +1？ 因为 Calendar 返回月的时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DATE));
        System.out.println("时：" + c.get(Calendar.HOUR));
        System.out.println("分：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calendar 没有专门的格式化方法，所以需要程序员直接来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE)
                + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));

    }
}
