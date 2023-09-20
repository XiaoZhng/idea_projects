package com.zledu.override_;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("tim", 18);
        System.out.println(person.say());

        Student student = new Student("jams", 20, 20211030, 95);
        System.out.println(student.say());
    }
}
