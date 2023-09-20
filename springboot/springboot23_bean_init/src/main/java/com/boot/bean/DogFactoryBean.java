package com.boot.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
