package com.zledu.test;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Alonso
 */
public class employee implements Comparator {
    private int id;
    private String name;
    private int age;
    private double sal;

    public employee() {
        System.out.println("emp...");
    }

    public employee(int id) {
        this.id = id;
    }

    public employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public employee(int id, String name, int age, double sal) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        return ((String)o1).compareTo(((String)o2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return id == employee.id &&
                age == employee.age &&
                Double.compare(employee.sal, sal) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sal);
    }
}
