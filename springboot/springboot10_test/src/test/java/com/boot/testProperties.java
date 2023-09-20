package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alonso
 */
//@SpringBootTest
//@SpringBootTest(properties = {"test.prop = testProperties1"})
@SpringBootTest(properties = {"test.prop = testProperties1"}, args = {"--test.prop=testProperties2"})
public class testProperties {

    @Value("${test.prop}")
    private String prop;

    @Test
    void testProperties(){
        System.out.println(prop);
    }
}
