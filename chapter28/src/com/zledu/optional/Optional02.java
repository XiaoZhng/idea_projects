package com.zledu.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Alonso
 */
public class Optional02 {

    @Test
    public void test1(){

        Optional<Object> empty = Optional.empty();
        //判断 Optional封装的数据是否包含数据
        if (!empty.isPresent()){
            System.out.println("数据为空");
        }
        //如果 Optional封装的数据value为空，则get()报错，否则，value不为空时，返回value
        //System.out.println(empty.get());
        System.out.println(empty);
        System.out.println(empty.isPresent());//false
    }

    @Test
    public void test2(){
        String str = "hello";
        //str = null;
        //Optional.of(T t)：封装数据t生成 Optional对象，要求t非空，否则报错
        Optional<String> str1 = Optional.of(str);

        //get()：通常与of()方法搭配使用，用于获取内部的封装的数据value
        System.out.println(str1.get());
    }

    @Test
    public void test3(){

        String str = "aa";
        str = null;
        //Optional.ofNullable(T t1)：封装数据t赋给Optional内部的value，不要求t1非空
        Optional<String> str1 = Optional.ofNullable(str);

        //orElse(T t2)：如果Optional内部的value非空，则返回value值
        //如果value为空，则返回t1
        String str2 = str1.orElse(new String("bb"));
        System.out.println(str2);
    }
}
