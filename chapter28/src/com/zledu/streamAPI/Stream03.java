package com.zledu.streamAPI;

import com.zledu.test.employee;
import com.zledu.test.employeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alonso
 * Stream终止操作的使用
 */
public class Stream03 {

    @Test
    public void test1(){

        //1.匹配与查找
        List<employee> employees = employeeData.getEmployee();
        //allMath(Predicate p) --检查是否匹配所有元素
        //练习：是否所有的员工年龄大于18
        boolean age = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(age);//f

        //anyMath(Predicate p) --检查是否至少匹配一个元素
        //练习：是否存在员工的工资大于 7000
        boolean sal = employees.stream().anyMatch(e -> e.getSal() > 7000);
        System.out.println(sal);//t

        //noneMath(Predicate p) --检查是否没有匹配的元素
        //练习：是否存在 j 开头的名字
        //startsWith(s) 以 s 开头
        boolean name = employees.stream().noneMatch(e -> e.getName().startsWith("j"));
        System.out.println(name);//f

        //findFirst --返回第一个元素
        Optional<employee> first = employees.stream().findFirst();
        System.out.println(first); //Optional[employee{id=1001, name='jack', age=21, sal=6000.0}]

        //findAny --返回当前流中任意元素
        //parallelStream() 并行流
        Optional<employee> any = employees.parallelStream().findAny();
        System.out.println(any); //Optional[employee{id=1004, name='lucy', age=23, sal=9000.0}]

        //count --返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count); //6

        //max(Comparator c) --返回流中最大值
        //练习：返回最高工资
        //需要使用到 map() 映射
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSal());
        Optional<Double> max = doubleStream.max((e1, e2) -> Double.compare(e1, e2));
        System.out.println(max); //Optional[9000.0]
        //min(Comparator c) --返回流中最小值
        //练习：返回最低工资员工
        Optional<employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSal(), e2.getSal()));
        System.out.println(min); //Optional[employee{id=1001, name='jack', age=21, sal=6000.0}]

        //foreach(Comparator c) --内部迭代
        employees.stream().forEach(System.out ::println); //stream的终止操作
        System.out.println();
        //主体不一样
        employees.forEach(System.out ::println); //employees集合的普通方法
    }

    @Test
    public void test2(){

        //2.规约
        List<employee> employees = employeeData.getEmployee();
        //reduce(T identity, BinaryOperator) --可以将流中元素反复结合起来，得到一个值，返回 T
        //reduce(0, Integer::sum); 参数1：初始值 参数2：计算方式
        //练习：计算1-10自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Integer reduce = list.stream().reduce(0, Integer ::sum);//方法引用
        /**
         *  public interface BinaryOperator<T> extends BiFunction<T,T,T> {}
         *
         *  public static int sum(int a, int b) {
         *         return a + b;
         *     }
         *
         *   因为 sum()是传入两个参数，返回一个新的值，和 BinaryOperator接口继承的BiFunction类 传入两个参数，返回一个新的值 一致，
         *   所以可以使用 Integer ::sum;
         */
        Integer reduce = list.stream().reduce(0, (e1,e2) -> e1+e2);//lambda表达式
        System.out.println(reduce);//55

        //reduce(BinaryOperator) --可以将流中元素反复结合起来，得到一个值，返回 optional<T>
        //练习：计算员工工资总和
        Stream<Double> doubleStream = employees.stream().map(employee -> employee.getSal());
        //Optional<Double> salReduce = doubleStream.reduce(Double::sum);//方法引用
        // 不了解 Double::sum，可以手动计算总和 (s1, s2) -> s1 + s2
        Optional<Double> salReduce = doubleStream.reduce((s1, s2) -> s1 + s2);//lambda表达式
        System.out.println(salReduce);//Optional[43500.0]
    }

    @Test
    public void test3(){

        //3.收集
        List<employee> employees = employeeData.getEmployee();
        //collect(Collect c) --将流转换为其他形式，接收一个 Collector接口的实现，用于给 Stream中元素做汇总的方法
        //练习：查找工资大于7000的员工，结果返回 list、set
        List<employee> employeeList = employees.stream().filter(e -> e.getSal() > 7000).collect(Collectors.toList());
        employeeList.forEach(System.out ::println);

        System.out.println();

        Set<employee> employeeSet = employees.stream().filter(e -> e.getSal() > 7000).collect(Collectors.toSet());
        employeeSet.forEach(System.out ::println);
    }
}
