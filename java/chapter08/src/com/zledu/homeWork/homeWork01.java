package com.zledu.homeWork;

//定义一个Person类(name,age,job),初始化Perosn对象数组，有3个person对象,并按照age从大到小进行排序
// 提示：使用冒泡排序

public class homeWork01 {
    public static void main(String[] args) {
        //初始化Perosn对象数组 重写toString然后输出
        Person[] persons = new Person[3];
        persons[0] = new Person("jack", 18, "设计师");
        persons[1] = new Person("tom", 20, "摄影师");
        persons[2] = new Person("Alonso", 21, "程序员");

        for(int i = 0; i < persons.length; i++){
            System.out.println(persons[i]);
        }

        //按照age从大到小进行排序,使用冒泡排序
        System.out.println("排序后输出---");
        for(int i = 0; i < persons.length; i++){ //外层循环
            for(int j = 0; j < persons.length - 1 - i; j++){ //内层循环
                Person temp = null;
       //按照姓名长度排序 if(persons[j].getName().length() < persons[j+1].getName().length()){
                if(persons[j].getAge() < persons[j+1].getAge()){
                    temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
            }
        }

        //排序后输出
        for(int i = 0; i < persons.length; i++){
            System.out.println(persons[i]);
        }

    }
}
class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
