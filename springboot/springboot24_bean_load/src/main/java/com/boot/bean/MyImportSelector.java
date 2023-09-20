package com.boot.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Alonso
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {

        //根据任意条件确认是否加载bean
        try {
            Class<?> clazz = Class.forName("com.boot.bean.HH");
            if (clazz != null){
                return new String[]{"com.boot.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            return new String[0];
        }
        return null;
    }
}
