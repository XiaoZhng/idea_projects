package com.zledu.homework;

import java.util.HashSet;
import java.util.Objects;

public class Homework06 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        Per p1 = new Per(1001, "AA");
        Per p2 = new Per(1002, "BB");
        hashSet.add(p1);
        hashSet.add(p2);
        p1.name = "CC";
        hashSet.remove(p1);
        System.out.println(hashSet);//2 (1001,"CC")(1002,"BB")
        hashSet.add(new Per(1001, "CC"));
        System.out.println(hashSet);//3 (1001,"CC")(1002,"BB")(1001,"CC")
        hashSet.add(new Per(1001, "AA"));
        System.out.println(hashSet);//4 (1001,"CC")(1002,"BB")(1001,"CC")(1001,"AA")

    }
}

class Per{
    public String name;
    public int num;

    public Per( int num, String name) {
        this.name = name;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Per per = (Per) o;
        return num == per.num &&
                Objects.equals(name, per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    @Override
    public String toString() {
        return "Per{" + "num=" + num +
                " ,name='" + name + '\'' +
                '}';
    }
}