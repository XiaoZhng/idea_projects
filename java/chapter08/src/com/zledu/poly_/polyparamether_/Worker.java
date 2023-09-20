package com.zledu.poly_.polyparamether_;

public class Worker extends Employee{
    public Worker(String name, double salary){ //构造器，因为 Worker 继承 Employee，所以使用super()
        super(name, salary);
    }

    //普通员工 Work()方法
    public void Work(){
        System.out.println("普通员工：" + getName() + " is working...");
    }

    //普通员工要求重写getAnnual方法
    public double getAnnual(){
        return super.getAnnual() + getSalary();
    }
}
