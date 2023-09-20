package com.boot.bean;

import com.boot.bean.service.impl.BookServiceImpl2;
import com.boot.bean.service.impl.BookServiceImpl4;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Alonso
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //使用 AnnotationMetadata做判定

        //导入实现了 ImportBeanDefinitionRegistrar接口的类，通过 BeanDefinition注册器注册实名bean
        //实现对容器中bean的裁定，例如对现有bean的覆盖，进而达成不修改源代码的情况下更换实现效果
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(BookServiceImpl2.class).getBeanDefinition();
        registry.registerBeanDefinition("bookService", beanDefinition);
    }
}
