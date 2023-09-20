package com.boot.config;

import com.boot.bean.Dog;
import org.springframework.context.annotation.Import;

/**
 * @author Alonso
 */
@Import({Dog.class, DbConfig.class})
public class SpringConfig2 {

}
