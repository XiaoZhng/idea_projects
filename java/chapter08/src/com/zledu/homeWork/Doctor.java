package com.zledu.homeWork;

public class Doctor {
    //属性
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    //方法 构造器，getter,setter
    public Doctor(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    //重写equals()
    public boolean equals(Object obj) {
        //判断类中的对象是否和传入的obj对象是否为同一个对象
        if (this == obj) {
            return true;
        }
        //判断两个对象是否为同一类型
//        if(obj instanceof Doctor){
//            //向下转型,因为obj的运行类型是Doctor或者其子类型
//            Doctor d1 = (Doctor)obj;
//            return this.name.equals(d1.name) && this.age == d1.age && this.job.equals(d1.job)
//                    && this.gender.equals(d1.gender) && this.sal == d1.sal;
//        }
//        return false;
        //过关斩将，校验方式
        if (!(obj instanceof Doctor)) {
            return false;
        }
        //向下转型,因为obj的运行类型是Doctor或者其子类型
        Doctor d1 = (Doctor) obj;
        return this.name.equals(d1.name) && this.age == d1.age && this.job.equals(d1.job)
                && this.gender.equals(d1.gender) && this.sal == d1.sal;
    }
}