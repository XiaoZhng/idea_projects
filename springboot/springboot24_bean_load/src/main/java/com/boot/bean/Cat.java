package com.boot.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;

/**
 * @author Alonso
 */
@ConditionalOnClass(name = "com.boot.bean.Mouse")
@ConditionalOnMissingClass("com.boot.bean.Dog")
//有 mouse并且没有dog才加载cat
public class Cat {
}
