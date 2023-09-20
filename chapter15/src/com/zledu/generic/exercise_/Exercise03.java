package com.zledu.generic.exercise_;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("all")
public class Exercise03 {
    public static void main(String[] args) {
//        Employee jack = new Employee("jack", 20000.0, new MyDate(2000, 9, 9));
//        Employee tom = new Employee("tom", 30000.0, new MyDate(2000, 10, 10));
//        Employee lucy = new Employee("lucy", 40000.0, new MyDate(2000, 11, 11));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 20000.0, new MyDate(2002, 10, 11)));
        employees.add(new Employee("jack", 30000.0, new MyDate(2002, 10, 10)));
        employees.add(new Employee("lucy", 40000.0, new MyDate(2000, 11, 11)));

        //对集合中的元素进行排序
        //先按名字排序，名字相同就按照生日日期先后
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //判断传入的参数类型是否为 Employee
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("参数不正确...");
                }
                //名字排序
                int i = (emp1.getName()).compareTo(emp2.getName());
                if (i != 0){
                    return i;
                }

                //birthday的比较应该放在MyDate类中
                //封装后，将来的可维护性和复用性大大提高
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("排序后============");
        System.out.println(employees);
    }
}
