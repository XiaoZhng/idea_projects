package com.zledu.poly_;

public class Master {
    private String name;

    public Master(String name){

        this.name = name;
    }

    public void feed(Animal animal, Foot foot){
        System.out.println("主人" + name + " 给 " + animal.getName() + " 吃 " + foot.getName());
    }

    //主人给狗喂骨头
//    public void feed(Dog dog, Bone bone){
//        System.out.println("主人" + name + " 给 " + dog.getName() + " 吃 " + bone.getName());
//    }
//
//    //主人给猫喂鱼
//    public void feed(Cat cat, Fish fish){
//        System.out.println("主人" + name + " 给 " + cat.getName() + " 吃 " + fish.getName());
//    }

    //如果动物很多，食物很多
    //--> feed 方法很多，不利于管理和维护
    //问题是：代码的复用性不高，而且不利于代码维护
    //解决方案：多态
}
