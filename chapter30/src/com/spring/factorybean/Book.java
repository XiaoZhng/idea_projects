package com.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Alonso
 */
public class Book implements FactoryBean<AA> {
    @Override
    public AA getObject() throws Exception {
        AA aa = new AA();
        aa.setName("jack");
        return aa;
    }
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
