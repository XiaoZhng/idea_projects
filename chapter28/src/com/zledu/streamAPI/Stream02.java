package com.zledu.streamAPI;

import com.zledu.test.employee;
import com.zledu.test.employeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Alonso
 *
 * Stream中间操作的使用
 */
public class Stream02 {

    @Test
    public void test1(){

        //1.筛选与切片
        //filter(Predicate p) --接收 lambda，从流中排除某些元素
        List<employee> employees = employeeData.getEmployee();
        Stream<employee> stream = employees.stream();
        //查询员工表工资大于7000的员工
        stream.filter(e -> e.getSal() > 7000).forEach(System.out ::println);

        System.out.println("===================================");
        //limit(n) --截断流，使其元素不超过给定数量
        //stream.limit(3).forEach(System.out ::println);//stream执行了终止操作，所以不能再被使用
        employees.stream().limit(3).forEach(System.out ::println);

        System.out.println("===================================");
        //skip(n) --跳过元素，返回一个扔掉了前 n个 元素的流，若流中的元素不足 n个，则返回一个空流
        employees.stream().skip(3).forEach(System.out ::println);

        System.out.println("===================================");
        //distinct() --筛选，通过流所生成元素的 hashCode() 和 equals() 去重复元素
        employees.add(new employee(1010, "aaa"));
        employees.add(new employee(1010, "aaa"));
        employees.add(new employee(1010, "aaa"));
        employees.add(new employee(1010, "aaa"));
        employees.add(new employee(1010, "aaa"));
        //System.out.println(employees);

        employees.stream().distinct().forEach(System.out ::println);
    }

    @Test
    public void test2(){

        //2.映射
        //map(Function f) --接收一个函数作为参数，
        // 将元素转换成其他形式或提取信息，将函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(e -> e.toUpperCase() ).forEach(System.out ::println);

        //练习1：获取员工名字长度大于3的员工名字
        //先拿到名字，再通过 filter 筛选过滤
        List<employee> employee = employeeData.getEmployee();
        Stream<String> namesStream = employee.stream().map(e -> e.getName());
        namesStream.filter(name -> name.length() > 3).forEach(System.out ::println);
        System.out.println();

        //练习2：
//        list.stream().map(new Function<String, Object>() {
//            @Override
//            public Object apply(String s) {
//                return Stream02.formStringToStream(s);
//            }
//        });
        Stream<Stream<Character>> streamStream = list.stream().map(s -> Stream02.formStringToStream(s));
        streamStream.forEach(s -> {
            s.forEach(System.out ::println);
        });
        System.out.println();

        //flatMap(Function f) --接收一个函数作为参数，将流中的每个值都换成另一个流，
        // 然后把所有的流连接成一个流
        list.stream().flatMap(s -> Stream02.formStringToStream(s)).forEach(System.out ::println);

    }

    //将字符串中的对个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> formStringToStream(String str){
        ArrayList<Character> characters = new ArrayList<>();
        for (Character c : str.toCharArray()){
            characters.add(c);
        }
        return characters.stream();
    }

    @Test
    public void test3(){

        //3.排序
        //sorted() --自然排序
        List<Integer> integers = Arrays.asList(11, 33, 5567, 7876, 34, -3);
        integers.stream().sorted().forEach(System.out ::println);
        //抛异常，原因：employee没有实现Comparable接口
//        List<employee> employee = employeeData.getEmployee();
//        employee.stream().sorted().forEach(System.out ::println);

        //sorted(Comparator c) --定制排序
        List<employee> employee = employeeData.getEmployee();
        employee.stream().sorted( (o1,o2) -> {

            int compare = Integer.compare(o1.getAge(), o2.getAge());
            if (compare != 0){
                return compare;
            }else {
                return Double.compare(o1.getSal(), o2.getSal());
            }

        }).forEach(System.out ::println);
    }
}
