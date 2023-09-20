package com.zledu.poly_;

public class poly01 {
    public static void main(String[] args) {
        Master tom = new Master("tom..");
        Dog dog = new Dog("dou");
        Bone bone = new Bone("骨头..");
        tom.feed(dog, bone);

        Cat cat = new Cat("king..");
        Fish fish = new Fish("黄花鱼..");
        tom.feed(cat, fish);

        Pig pig = new Pig("gg");
        Rice rice = new Rice("米饭");
        tom.feed(pig,rice);
    }
}
