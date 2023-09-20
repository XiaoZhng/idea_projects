package com.zledu.annotation_;

public class Override_ {
    public static void main(String[] args) {

    }
}

class Father{
    public void fly(){
        System.out.println("Father fly()...");
    }
    public void say(){}
}
class Son extends Father{
    /**
     * 1.@Override 注解放在fly方法上，表示子类的fly方法是重写了父类的fly
     * 2.这里没有写 @Override 还是重写了父类fly
     * 3.如果你写了@Override注解，编译器就会去检查该方法是否真的重写了父类的方法，
     * 如果的确重写了，则编译通过，如果没有构成重写，则编译错误
     * 重要价值就是 语法校验
     * 看看 @Override的定义：
     * 解读：如果发现 @interface 表示一个 注解类
     * @Target 是修饰注解的注解，称为元注解
     *  @Target(ElementType.METHOD)
     *  @Retention(RetentionPolicy.SOURCE)
     *  public @interface Override {
     *  }
     */
    @Override
    public void fly() {
        System.out.println("Son fly()...");
    }
    @Override
    public void say(){}
}