package com.zledu.homeWork.homeWork05;

public class homeWork05 {
    public static void main(String[] args) {
        //工人全年工资
        worker worker = new worker("jack", 3000, 12);
        worker.printSal();

        //农民全年工资
        Peasant peasant = new Peasant("tom", 2000, 12);
        peasant.printSal();

        //教师全年工资
        Teacher teacher = new Teacher("tim", 5000, 12);
        teacher.setClassSal(100);
        teacher.setClassDay(30);
        teacher.printSal();

        //科学家全年工资
        Scientist scientis = new Scientist("Alonso", 30000, 12);
        scientis.setBonus(50000);
        scientis.printSal();

        //服务生全年工资
        Waiter waiter = new Waiter("koko", 3000, 12);
        waiter.printSal();
    }
}
