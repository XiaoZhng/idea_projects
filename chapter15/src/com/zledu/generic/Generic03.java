package com.zledu.generic;

@SuppressWarnings({"all"})
    public class Generic03 {
    public static void main(String[] args) {

        //注意，特别强调：E具体的数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型
        Person<String> person1 = new Person<String>("jack");
        person1.show();//String

        Person<Integer> person2 = new Person<Integer>(1);
        person2.show();//Integer
    }
}

//泛型的作用：可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值类型，或者是参数类型。
class Person<E>{
    E n; //E表示 n的数据类型，该数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型

    public Person(E n) { //E也可以是参数类型
        this.n = n;
    }
    public E f(){ //E也可以是返回类型
        return n;
    }
    public void show(){
        System.out.println(n.getClass());
    }
}