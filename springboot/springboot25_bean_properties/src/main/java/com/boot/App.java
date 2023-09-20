package com.boot;

import com.boot.bean.CartoonCatAndMouse;
import com.boot.bean.CartoonProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @author Alonso
 */
@SpringBootApplication(excludeName = "org.springframework.boot.task.TaskSchedulerBuilder")
//@Import(CartoonCatAndMouse.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        CartoonCatAndMouse bean = context.getBean(CartoonCatAndMouse.class);
        bean.play();
    }

    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(0);
        //System.out.println(list);

        String str = "";
        System.out.print(str.split(",").length);
    }
}
