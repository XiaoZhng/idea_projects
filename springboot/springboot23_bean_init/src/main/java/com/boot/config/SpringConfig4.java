package com.boot.config;

import com.boot.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Alonso
 */
//@Configuration
//@ComponentScan(basePackages = {"com.boot"})
@Import(MyImportSelector.class)
public class SpringConfig4 {

}
