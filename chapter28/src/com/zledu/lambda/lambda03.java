package com.zledu.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Alonso
 */
public class lambda03 {

    /**
     * java内置的4大核心函数式接口
     *
     * 消费型接口 Consumer<T>    void accept(T t)
     * 供给型接口 Supplier<T>    T get()
     * 函数型接口 Function(T,R)  R apply(T t)
     * 断定型接口 Predicate<T>   boolean(T t)
     */

    @Test
    public void test1(){

        m1(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });
        System.out.println("==============");

        m1(400, aDouble -> System.out.println(aDouble));
    }

    public void m1(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){

        List<String> arrayList = new ArrayList<>();
        arrayList.add("北京");
        arrayList.add("天津");
        arrayList.add("南京");
        List<String> list = m2(arrayList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list);
        System.out.println("==============");

        System.out.println(m2(list, s -> s.contains("京")));
    }

    //根据给定的规则，过滤集合中的字符串，此规则由 Predicate的方法决定
    public List<String> m2(List<String> list, Predicate<String> pre){

        ArrayList<String> arrayList = new ArrayList<>();

        for (String s : list) {
            if (pre.test(s)){
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
