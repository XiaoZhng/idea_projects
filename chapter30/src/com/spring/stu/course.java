package com.spring.stu;

/**
 * @author Alonso
 */
public class course {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "course{" +
                "name='" + name + '\'' +
                '}';
    }
}
