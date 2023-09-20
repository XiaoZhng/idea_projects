package com.zledu.optional;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author Alonso
 */
public class Optional01 {

    /**
     * Optional类：为了在程序中避免出现空指针异常而创建的的
     * 常用方法：ofNullable(T t)
     *         orElse(T t)
     *
     * Optional.of(T t) --创建一个 Optional 实例，t必须非空
     * Optional.empty() --创建一个空的 Optional 实例
     * Optional.ofNullable(T t) --t可以为null
     */

    @Test
    public void test1(){

        Girl girl = new Girl();
        //girl = null;
        //Optional.of(T t)：必须保证t非空
        Optional<Girl> girl1 = Optional.of(girl);
    }

    @Test
    public void test2(){

        Girl girl = new Girl();
        girl = null;
        //Optional.ofNullable(T t)：t可以为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);

        //orElse(T t1)：如果当前的Optional内部封装的t是非空的，则返回内部的t
        //  如果内部的t是空的，则返回orElse()方法中的参数t1
        Girl girl2 = girl1.orElse(new Girl("lucy"));
        System.out.println(girl2);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    //优化
    public String getGirlName2(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
//        String girlName = getGirlName(boy);
//        System.out.println(girlName);

        String girlName = getGirlName2(boy);
        System.out.println(girlName);

    }

    //使用 Optional类的 getGirlName3
    public String getGirlName3(Boy boy){

        // boy 可以为空
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //boy1一定有非空
        Boy lucy = boy1.orElse(new Boy(new Girl("lucy")));
        //lucy不会产生空指针，不过会为null
        Girl girl = lucy.getGirl();
        //girl可能为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl king = girl1.orElse(new Girl("king"));
        //king一定有非空
        return king.getName();

    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String girlName3 = getGirlName3(boy);
        System.out.println(girlName3);

    }
}
