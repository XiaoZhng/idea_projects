package com.zledu.enum_.exercise_;

public class Exercise04 {
    public static void main(String[] args) {
        week[] values = week.values();
        for (week o : values) {
            System.out.println(o);
            //System.out.println(o.getName());
        }

    }
}
enum week{
    monday("星期一"), tuesday("星期二"), wednesday("星期三"), thursday("星期四"),
    friday("星期五"), saturday("星期六"), sunday("星期日");
    private String name;

    week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}