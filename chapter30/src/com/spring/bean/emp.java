package com.spring.bean;

/**
 * @author Alonso
 * 员工类
 */
public class emp {
    private String name;
    private Integer age;
    //一个员工对应一个部门
    private dept dept;
    //级联赋值第二种写法，需要生成 get方法
    public dept getDept() {
        return dept;
    }
    public void setDept(com.spring.bean.dept dept) {
        this.dept = dept;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void add(){
        System.out.println(name + "-" + age + "-" + dept);
    }
}
