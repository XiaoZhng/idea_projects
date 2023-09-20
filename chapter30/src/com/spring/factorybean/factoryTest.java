package com.spring.factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Alonso
 */
public class factoryTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
//        Book book = context.getBean("book", Book.class);
        AA aa = context.getBean("book", AA.class);
//        System.out.println(book);//普通bean：com.spring.factorybean.Book@4abdb505
        System.out.println(aa);//工厂bean：com.spring.factorybean.AA@42d8062c
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        AA a1 = context.getBean("aa", AA.class);
        AA a2 = context.getBean("aa", AA.class);
        //单实例
        System.out.println(a1);//com.spring.factorybean.AA@33723e30
        System.out.println(a2);//com.spring.factorybean.AA@33723e30
        //多实例
        System.out.println(a1);//com.spring.factorybean.AA@33723e30
        System.out.println(a2);//com.spring.factorybean.AA@64f6106c
    }

    //bean生命周期过程
    @Test
    public void test3(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Life life = context.getBean("life", Life.class);
        //life.add();
        System.out.println("第四步：获取到bean");
        //手动让bean实例销毁
        context.close();
    }

    //自动装配
    @Test
    public void test4(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Life life = context.getBean("life", Life.class);
        System.out.println(life);//Life{aa=AA{name='null'}}
    }
}
