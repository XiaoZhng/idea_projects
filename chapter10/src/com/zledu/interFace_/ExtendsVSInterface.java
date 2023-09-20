package com.zledu.interFace_;

public class ExtendsVSInterface {
    public static void main(String[] args) {
        littlemonkey littlemonkey = new littlemonkey("悟空");
        littlemonkey.play();
        littlemonkey.swiming();
        littlemonkey.flying();
    }
}

class monkey{
    private String name;

    public monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void play(){
        System.out.println(name + "会玩耍");
    }
}
interface fishable{
    void swiming();//等价 public static final void swiming();
}
interface birdable{
    void flying();
}

//继承+接口
//小结：
//1.当子类继承了父类，就自动拥有了父类的功能
//2.如果子类需要扩展功能，可以通过实现接口的方式扩展
//3.可以理解 实现接口 是 对java 单继承机制的一种补充
class littlemonkey extends monkey implements fishable,birdable{
    public littlemonkey(String name) {
        super(name);
    }

    @Override
    public void swiming() {
        System.out.println(getName() +"和鱼学会了游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "和鸟学会了飞翔");
    }
}