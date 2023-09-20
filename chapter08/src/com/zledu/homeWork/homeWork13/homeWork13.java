package com.zledu.homeWork.homeWork13;

public class homeWork13 {
    public static void main(String[] args) {
        Student student = new Student("jack", "男", 18, 2022001);
        student.printinfo_stu(); //封装
        System.out.println("------------------------------");
        Teacher teacher = new Teacher("tim", "男", 30, 5);
        teacher.printInfo_tea();

        //定义多态数组,保存2个学生和2个老师,按年龄高到低排序
        Person[] persons = new Person[4];
        persons[0] = new Student("aaa", "女", 19, 2022002);
        persons[1] = new Student("bbb", "男", 20, 2022003);
        persons[2] = new Teacher("AAA", "男", 31, 6);
        persons[3] = new Teacher("BBB", "女", 32, 7);

        System.out.println("---排序前的输出---");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        //因为排序方法是创建在homeWork13里的，所以只有创建homeWork13对象才能调用
        homeWork13 homeWork13 = new homeWork13();
        homeWork13.pai(persons);

        System.out.println("---排序后的输出---");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        //使用printAce方法
        System.out.println("------使用printAce()后输出------");
        for (int i = 0; i < persons.length; i++) { //遍历多态数组
            homeWork13.printAce(persons[i]);
        }
    }

    //排序方法
    public void pai(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) { //外层循环
            for (int j = 0; j < persons.length - 1 - i; j++) { //内层循环
                Person temp = null; //临时变量
                if (persons[j].getAge() < persons[j + 1].getAge()) { // 判断年龄从大到小
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    //定义方法，形参为Person类型，功能：调用学生study()和教师teach()
    public void printAce(Person per) {
        if (per instanceof Student) { //per的运行类型如果是student
//            Student student = (Student)per;
            //向下转型
            ((Student) per).study();
        } else if (per instanceof Teacher) { //per的运行类型如果是teacher
            ((Teacher) per).teach();
        } else {
            System.out.println("调用失败");
        }
    }
}
