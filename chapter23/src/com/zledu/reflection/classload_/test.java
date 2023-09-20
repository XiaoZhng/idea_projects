package com.zledu.reflection.classload_;

/**
 * @author Alonso
 */
public class test {
    public static void main(String[] args) {
        AA aa = new AA();
        BB bb = new BB();
    }
}
class AA{
    public AA() {
        System.out.println("AA");
    }
}

class BB extends AA{
    public BB() {
        System.out.println("BB");
    }
}
class Base{
    public Base() {
        System.out.print("base");
    }
}

class Alpha extends Base{
    public static void main(String[] args) {
        new Alpha();//base
        new Base();//base
    }
}