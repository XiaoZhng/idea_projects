package com.zledu.lambda;

import com.zledu.test.employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Alonso
 */
public class lambda04 {

    /**
     * 方法引用的使用
     *
     * 1.使用情境：当要传递给 Lambda体的操作，已经有实现的方法了，可以使用方法引用！
     *
     * 2.方法引用，本质上就是 Lambda表达式，而 Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
     *
     * 3.使用格式： 类(或对象) :: 方法名
     *
     * 4.具体分为如下的三种个情况：
     *  情况1     对象 :: 非静态方法
     *  情况2     类 :: 静态方法
     *  情况3     类 :: 非静态方法
     *
     * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！(针对情况1和情况2)
     */

    @Test
    public void test1() {

        //情况一： 对象 :: 实例方法
        //Consumer中的void accept(T t)
        //PrintStream中的void println()
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("=================");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("aaa");
    }

    @Test
    public void test2() {

        //Supplier中的T get()
        //employee中的String getName()
        employee emp = new employee(1001, "jack", 20, 5000);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("=================");
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }


    @Test
    public void test3(){

        //情况二：类 :: 静态方法
        //Comparator中的int compare(T t1, T t2)
        //Integer中的int compare(T t1, T t2)
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12,34));

        System.out.println("==================");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(43,32));
    }

    @Test
    public void test4(){

        //Function中的R apply(T t)
        //Math中的Long round(Double d)
        Function<Double, Long> fun1 = t -> Math.round(t);
        System.out.println(fun1.apply(12.3));

        System.out.println("==================");
        Function<Double, Long> fun2 = Math::round;
        System.out.println(fun2.apply(12.6));
    }


    @Test
    public void test5(){

        //情况三：类 :: 实例方法 (难点)
        //Comparator中的int compare(T t1, T t2)
        //String中的int t1.compareTo(t2)
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("jack", "jaca"));

        System.out.println("==================");
        Comparator<String> com2 = String ::compareTo;
        System.out.println(com2.compare("jaca", "jack"));
    }

    @Test
    public void test6(){

        //BiPredicate中的boolean test(T t1, T t2)
        //String中的boolean t1.equals(t2)
        BiPredicate<String, String> b1 = (s1,s2) -> s1.equals(s2);
        System.out.println(b1.test("aaa", "bbb"));

        System.out.println("==================");
        BiPredicate<String, String> b2 = String ::equals;
        System.out.println(b2.test("aaa", "aaa"));
    }

    @Test
    public void test7(){

        //Function中的R apply(T t)
        //employee中的String getName()
        employee emp = new employee(1002, "tom", 21, 6000);
        Function<employee, String> f1 = fu -> fu.getName();
        System.out.println(f1.apply(emp));

        System.out.println("==================");
        Function<employee, String> f2 = employee ::getName;
        System.out.println(f2.apply(emp));
    }
}
