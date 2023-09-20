package com.zledu.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {
        //应用实例：现有一个继承结构如下：要求创建一个Person对象
        //2个Student 对象和2个 Teacher对象，统一放在数组中，并调用每个对象say对象
        Person[] person= new Person[5];
        person[0] = new Person("jack", 20);
        person[1] = new Student("jam",18,100);
        person[2] = new Student("Alonso", 21, 90);
        person[3] = new Teacher("smith", 31, 5000);
        person[4] = new Teacher("Tom", 30, 7000);

        //循环遍历多态数组，调用say()
        for(int i = 0; i < person.length; i++){
            //提示：person[i] 编译类型是 Person， 运行类型是根据实际情况由JVM来判断
            System.out.println(person[i].say()); //动态绑定机制
            //使用 类型判断 + 向下转型
            if (person[i] instanceof Student){ //判断person[i] 的运行类型是不是Student
                //第一种方法
//                Student student = (Student)person[i];
//                student.study();
                //第二种方法
                ((Student)person[i]).study();
            } else if (person[i] instanceof Teacher){
                ((Teacher)person[i]).teach();
            } else if (person[i] instanceof Person){

            }else{
                System.out.println("输出错误！");
            }
        }
    }
}
