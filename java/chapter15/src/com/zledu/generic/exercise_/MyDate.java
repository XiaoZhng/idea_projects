package com.zledu.generic.exercise_;

public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    //MyDate类实现 Comparable接口
    @Override
    public int compareTo(MyDate o) {
        //日期(年排序)
        int i1 = year - (o.getYear());
        if (i1 != 0){
            return i1;
        }

        //日期(月排序)
        int i2 = month - (o.getMonth());
        if (i2 != 0){
            return i2;
        }

        //日期(日排序)，如果上面年和月都相等，则比较日
        return day - o.getDay();
    }
}
