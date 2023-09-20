package com.zledu.extend_.exercise;

//编写PC子类，继承Computer类添加特有属性【品牌brand】
public class PC extends Computer{
    private String brand;

    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void info(){
        System.out.println("PC信息:" + getDetails() + "brand=" + brand);
    }
}
