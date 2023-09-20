package com.zledu.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise2 {
@SuppressWarnings({"all"})
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("jack", 6000.0, new MyDate(2001, 11, 1)));
        list.add(new Employee("tom", 700.0, new MyDate(2000, 11, 1)));
        list.add(new Employee("lucys", 8000.0, new MyDate(2000, 9, 1)));
        list.add(new Employee("jack", 9000.0, new MyDate(2001, 10, 2)));
        System.out.println(list);
 //排序
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //判断传进来的是不是 Employee对象
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("参数类型不正确...");
                    return 0;
                }

                int i = (emp1.getName()).compareTo(emp2.getName());
                if (i != 0){ //不等于0，就代表比较出结果了
                    return i;
                }

                //下面是对 birthday的比较，因此，我们最好把这个比较，放在MyDay里完成
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });
        System.out.println("排序后======");
        System.out.println(list);
    }
}
/*
    定义 Employee 类
    (1) 该类包含 name,sal,birthday，其中birthday为 MyDate类
    (2) 给属性定义 getter setter
    (3) 重写 toString()，输出name，sal，birthday
    (4) MyDate类包含 month,day,year，并定义getter setter
    (5) 创建该类三个对象，放入 ArrayList集合中(ArrayList 需要使用泛型来定义)，对集合元素进行排序，并遍历输出
    排序方式：调用 ArrayList的 sort方法，传入 Comparator对象(使用泛型)，先按照name排序，
        如果name相同，按照生日日期排序
 */

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  "\nname=" + name + ", sal=" + sal + ", birthday=" + birthday;
    }
}

class MyDate implements Comparable<MyDate>{
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
        return "year=" + year +", month=" + month + ", day=" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        int years = year - o.getYear();
        if (years != 0){
            return years;
        }

        int months = month - o.getMonth();
        if (months != 0){
            return months;
        }

        int days = day - o.getDay();
        if (days != 0){
            return days;
        }
        return 0;
    }
}