package com.zledu.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {

        //第一代日期类

        //1.获取当前的时间
        //2.这里的Date 类是在java.util包
        //3.默认输出的日期格式是国外格式，因此通常需要对格式进行转换
        Date date = new Date();//获取当前系统时间
        System.out.println(date);
        Date d2 = new Date(767969);//通过指定毫秒数得到时间
        System.out.println("d2= " + d2);//获取某个时间对应的毫秒数

        //1.创建 SimpleDateFormat对象，可以指定相应的格式
        //2.这里的格式使用的字母是规定好的，不能乱写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
        String format = sdf.format(date);
        System.out.println(format);

        //1.可以把一个格式化的String 转成对应的 Date
        //2.得到Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        //3.在把String -> Date，使用 sdf 格式需要和给的String的格式一样，否则会抛出转换异常
        String s = "2020-01-01 10:10:10 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse=" + parse);
    }
}
