package com.zledu.poly_.polyparamether_;

import com.zledu.poly_.Master;

public class Manage extends Employee{
    //经理类有奖金bonus方法
    private double bonus;
    public Manage(String name, double salary, double bonus){ //构造器，因为 Manage 继承 Employee，所以使用super()
        super(name, salary);
        this.bonus = bonus;
    }

    //经理类有管理manage方法
    public void manage(){
        System.out.println("经理：" + getName() + " is managing...");
    }

    //经理类要求重写getAnnual方法

//    @Override
//    public double getAnnual() {
//        return super.getAnnual();
//    }
    public double getAnnual(){
        return super.getAnnual() + bonus;
    }
}
