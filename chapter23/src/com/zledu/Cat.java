package com.zledu;

/**
 * @author Alonso
 */
public class Cat {
    private String name = "tom";
    public int age = 10;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi(){
        //System.out.println("hi," + name);
    }

    public void cry(){
        System.out.println(name + "喵喵叫..");
    }
}
