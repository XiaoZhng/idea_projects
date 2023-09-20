package com.spring5.nullable;

import org.springframework.lang.Nullable;

/**
 * @author Alonso
 */
public class Book {

    //@Nullable 注解可以使用在方法上面，属性上面，参数上面，
    // 表示方法返回可以为空，属性值可以为空，参数值可以为空

    //注解使用在属性上面，属性值可以为空

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    //注解用在方法上面，方法返回值可以为空
    public void read(){
        System.out.println(name);
    }
    //注解使用在方法参数里面，方法参数可以为空
    public void look(@Nullable String context){}
}
