package com.zledu.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDetail {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //1.给泛型指向数据类型，要求是引用数据类型，不能是基本数据类型
        ArrayList<Integer> list = new ArrayList<Integer>();//正确写法
        //ArrayList<int> list2 = new ArrayList<int>();//错误写法

        //说明： 因为 E 指定了 A 类型，构造器传入了 new A()
        //2.在指定泛型具体类型后，可以传入该类型或者其子类类型
        Pig<A> aPig1 = new Pig<A>(new A());
        aPig1.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();

        //3.泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，我们往往简写
        //编译器会进行类型推断，推荐使用下面写法
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        ArrayList<Pig> pigs = new ArrayList<>();

        //3.1 如果没写泛型，泛型默认就是 Object
        ArrayList arrayList = new ArrayList();//等价于 ArrayList<Object> arrayList = new ArrayList<Object>();
        /*
            public boolean add(E(Object) e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
         */
    }
}

class A{}
class B extends A{}
class Pig<E>{
    E n;

    public Pig(E n) {
        this.n = n;
    }
    public void f(){
        System.out.println(n.getClass());
    }
}