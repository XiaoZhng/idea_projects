package com.boot.bean;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author Alonso
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
//        System.out.println("class= " + metadata.getClassName());
//        System.out.println(metadata.hasAnnotation("org.springframework.context.annotation.Configuration"));
//        Map<String, Object> attributes = metadata.getAnnotationAttributes("org.springframework.context.annotation.ComponentScan");
//        System.out.println(attributes);
//        System.out.println("==================");

        //各种条件的判定，判定完毕后，决定是否加载指定的bean
        boolean b = metadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        if (b) {
            return new String[]{"com.boot.bean.Dog"};
        }
            return new String[]{"com.boot.bean.Cat"};
    }
}
