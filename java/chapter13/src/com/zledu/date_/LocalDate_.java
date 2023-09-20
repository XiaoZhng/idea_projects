package com.zledu.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {

        //第三代日期类

        //1.使用 now() 返回表示当前时间的 对象
        LocalDateTime now = LocalDateTime.now(); //LocalDate.now(); LocalTime.now();
        System.out.println(now);

        //2.使用DateTimeFormatter 对象来进行格式化
        //创建 DateTimeFormatter对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");
        String format = dtf.format(now);
        System.out.println("格式化= " + format);


        System.out.println("年：" + now.getYear());
        System.out.println("月：" + now.getMonth());
        System.out.println("月：" + now.getMonthValue());
        System.out.println("日：" + now.getDayOfMonth());
        System.out.println("时：" + now.getHour());
        System.out.println("分：" + now.getMinute());
        System.out.println("秒：" + now.getSecond());

        LocalDate now1 = LocalDate.now();//可以获取年月日
        LocalTime now2 = LocalTime.now();//可以获取时分秒

        //提供 plus 和 minus方法可以对当前时间进行加或减
        //看看100天后，是什么时候 输出 年月日 时分秒
        LocalDateTime localDateTime = now.plusDays(100);
        String format1 = dtf.format(localDateTime);
        System.out.println("100天后= " + format1);

        //在 123分钟前是什么时候 输出 年月日 时分秒
        LocalDateTime localDateTime1 = now.minusMinutes(123);
        System.out.println("123分钟前= " + dtf.format(localDateTime1));
    }
}
