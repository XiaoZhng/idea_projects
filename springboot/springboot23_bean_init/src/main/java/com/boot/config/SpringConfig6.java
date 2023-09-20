package com.boot.config;

import com.boot.bean.MyPostProcessor;
import com.boot.bean.MyRegistrar;
import com.boot.bean.MyRegistrar2;
import com.boot.bean.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

/**
 * @author Alonso
 */
@Import({BookServiceImpl1.class, MyRegistrar.class, MyRegistrar2.class , MyPostProcessor.class})
public class SpringConfig6 {

}
