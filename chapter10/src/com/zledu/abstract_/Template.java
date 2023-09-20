package com.zledu.abstract_;

abstract public class Template { //父类

    public abstract void job();//抽象方法

    public void time(){
        //得到开始的时间
        long start = System.currentTimeMillis();
        job(); //动态绑定机制
        //得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("统计完成时间=" + (end - start));
    }

}
class CC extends Template{
    @Override
    public void job() {

    }
}