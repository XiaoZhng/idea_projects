package com.zledu.override_;

//编写一个Student类，继承Person类，添加id，score属性/private，以及构造器，
// 定义say方法(返回自我介绍的信息)
public class Student extends Person{
    //因为父类默认构造器被覆盖所以报错
    private int id;
    private double score;

    public Student(String name, int age, int id, double score){
        super(name, age); //调用父类构造器
        this.id = id;
        this.score = score;
    }
    public String say(){ //这里体现了super的好处，代码复用
        return super.say() + " id=" + id + " score=" + score;
    }
}
