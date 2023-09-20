package com.spring.factorybean;

/**
 * @author Alonso
 */
public class Life {
    private String name;
    private AA aa;
    public void setAa(AA aa) {
        this.aa = aa;
    }
    public void say(){
        System.out.println(aa);
    }
    public Life() {
        System.out.println("第一步：调用无参构造器创建bean实例");
    }
    public void setName(String name) {
        System.out.println("第二步：为bean的属性值设置");
        this.name = name;
    }
    public void add() {
        System.out.println("第三步：调用bean的初始化方法，需要配置 init-method=\"add\"");
    }
    public void destroyBean(){
        System.out.println("第五步：容器关闭，调用销毁方法，需要配置");
    }

    @Override
    public String toString() {
        return "Life{" +
                "aa=" + aa +
                '}';
    }
}
