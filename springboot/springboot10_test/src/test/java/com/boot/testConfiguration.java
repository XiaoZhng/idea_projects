package com.boot;

import com.config.MSGConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Alonso
 */
@SpringBootTest
//引入第三方Bean
@Import({MSGConfig.class})
public class testConfiguration {

    @Autowired
    private String msg;

    @Test
    void testConfiguration(){
        System.out.println(msg);
    }
}
