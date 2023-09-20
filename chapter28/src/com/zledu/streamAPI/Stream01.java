package com.zledu.streamAPI;

import com.zledu.test.employee;
import com.zledu.test.employeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Alonso
 */
public class Stream01 {

    /**
     * StreamAPI 概述
     *
     * 1.Stream关注的是对数据的运算，与CPU打交道
     *  集合关注的是数据的存储，与内存打交道
     *
     * 2.
     * Stream 自己不会存储元素
     * Stream 不会改变源对象，相反，他们会返回一个持有结果的新Stream
     * Stream 操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
     *
     * 3.Stream 执行流程
     * Stream的实例化
     * 一系列的中间操作(过滤、映射、...)
     * 终止操作
     *
     * 4.说明
     * 4.1 一个中间操作链，对数据源的数据进行处理
     * 4.2 一旦执行终止操作，就会执行中间操作链，并产生结果，之后，不会再被使用
     *
     */

    //Stream的实例化

    @Test
    public void test1(){

        //创建 Stream方式一：通过集合
        List<employee> employees = employeeData.getEmployee();

        //default Stream<E> stream():返回一个顺序流
        Stream<employee> stream = employees.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<employee> employeeStream = employees.parallelStream();
    }

    @Test
    public void test2(){

        //创建 Stream方式二：通过数组
        //调用Arrays类的static <T> Stream<T> stream(T[] array):返回一个流
        int[] ints = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(ints);

        employee e1 = new employee(1001, "jack");
        employee e2 = new employee(1001, "tom");
        employee[] employees = new employee[]{e1, e2};
        Stream<employee> stream1 = Arrays.stream(employees);
    }

    @Test
    public void test3(){

        //创建 Stream方式三：通过 Stream的of()
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void test4(){

        //创建 Stream方式四：创建无限流
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        });

        //lambda表达式写法
        Stream.iterate(0, integer -> integer + 2).limit(10).forEach(System.out ::println);

        System.out.println("===================================");
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(new Supplier<Object>() {
            @Override
            public Object get() {
                return Math.random();
            }
        });

        //方法引用写法
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out ::println);
        System.out.println("===================================");
        Stream.generate(Math ::random).limit(2).forEach(System.out ::println);
    }
}
