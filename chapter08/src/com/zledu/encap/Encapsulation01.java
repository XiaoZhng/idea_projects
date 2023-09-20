package com.zledu.encap;

import sun.management.Agent;

public class Encapsulation01 {
    public static void main(String[] args) {
        //如果要使用快捷键alt+R，需要先配置主类
        //第一次，我们使用鼠标点击形式运行程序，后面就可以用了
        Person person = new Person();
        person.setName("jack");
        person.setAge(30);
        person.setSalary(30000);

        System.out.println(person.info());
        //System.out.println(person.getSalary());

        //如果我们自己使用构造器指定属性
        Person jams = new Person("jams", 20, 50000);
        System.out.println("=======jams信息=========");
        System.out.println(jams.info());
    }
}

/*
* com.zledu.encap:Encapsulation01.java:
* 不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认
* 年龄，必须在1-120，年龄，工资不能直接查看，name的长度在 2-6字符 之间
* */
class Person{
    public String name; //名字公开
    private int age; //年龄(age) 私有化
    private double salary; //工资(salary) 私有化

    //自己写setXXX 和 个体XXX 太慢，使用快捷键
    //然后根据要求完善代码


    public Person() { //无参构造器
    }

    //有三个属性的构造器
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //我们可以将set方法写在构造器中，这样仍然可以验证
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //判断 加入对数据的校验，相当于增加了业务逻辑
        if(name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        }else{
            System.out.println("名字的长度不对(范围2-6字符)，默认名字：佚名");
            this.name = "佚名";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //判断 年龄在1-120之间
        if(age >= 1 && age <= 120) { //如果是合理范围
            this.age = age;
        }else{
            System.out.println("设置的年龄不对(范围1-120)，输出默认年龄18");
            this.age = 18; //设置默认年龄
        }
    }

    public double getSalary() {
        //这里可以增加对当前对象的权限判断

        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info(){
        return "信息为 name=" + name + " age=" + age + " 薪水=" + salary;
    }
}