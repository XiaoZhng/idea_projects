package com.zledu.lambda;

import com.zledu.test.employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Alonso
 */
public class lambda05 {

    /**
     * 1.构造器引用
     *  和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
     *  抽象方法的返回值类型即为构造器所属的类的类型
     *
     * 2.数组引用
         *  可以把数组看做是一个特殊的类，则写法与构造器引用一致
     */

        @Test
        public void test1(){

            //构造器引用
            //供给型接口
            //Supplier中的T get()
            Supplier<employee> su1 = () -> new employee();
            System.out.println(su1.get());

            System.out.println("=================");
            Supplier<employee> su2 = employee ::new;
            System.out.println(su2.get());
        }

        @Test
        public void test2(){

            //Function中的R apply(T t)
            Function<Integer, employee> f1 = id -> new employee(id);
            System.out.println(f1.apply(10));

            System.out.println("=================");
            Function<Integer, employee> f2 = employee::new;
            System.out.println(f2.apply(20));
        }

        @Test
        public void test3(){

            //BiFunction中的R apply(T t, U u)
            BiFunction<Integer, String, employee> b1 = (id,s1) -> new employee(id,s1);
            System.out.println(b1.apply(10, "jack"));

            System.out.println("=================");
            BiFunction<Integer, String, employee> b2 = employee::new;
            System.out.println(b2.apply(20, "tom"));
        }

    @Test
    public void test4(){

        //数组引用
        //Function中的R的 apply(T t)
        Function<Integer, String[]> f1 = i1 -> new String[i1];
        String[] apply = f1.apply(2);
        System.out.println(Arrays.toString(apply));

        System.out.println("=================");
        Function<Integer, String[]> f2 = String[] ::new;
        System.out.println(Arrays.toString(f2.apply(3)));

    }
}
