package com.zledu.poly_.polyparamether_;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary){ //构造器
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //计算年工资getAnnual
    public double getAnnual(){
        return 12 * salary;
    }
}
