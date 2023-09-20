package com.zledu.string_;

public class StringExercise10 {
    public static void main(String[] args) {

    }
}
class Test1{
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};
    public void change(String str, char ch[]){
        str = "java";
        ch[0] = 'h';
        //System.out.println("str= " + str + " ch[]= " + ch);//java 'h', 'a', 'v', 'a'
    }

    /**
     * 1. Test1 ex = new Test1(); new一个Test1对象 对象创建了str指向堆的value，然后再指向池中的"hsp"
     *    创建了ch数组，指向堆中的 {'j', 'a', 'v', 'a'}
     * 2. ex.change(ex.str, ex.ch); 调用change()方法,一调方法就会产生新的栈，把ex.str传入方法中，ex.str还是指向堆中的str
     *    当执行str = "java";的时候，原本新栈中的str指向堆中的str就断掉了，就指向了常量池中的"java"
     *    把ex.ch传入方法中，方法中把数组中的第一个元素改为 'h'，
     *    这时堆中的ch数组就变成了 {'h', 'a', 'v', 'a'}，当执行完调用方法的语句后，新的栈就销毁了，就就回到了main
     * 3. System.out.println(ex.str + "and"); main方法中，ex.str是指向堆中的str的，str指向value,指向常量池中的"hsp"
     *    所以值没有发生变化，还是"hsp"，所以输出 hspand
     * 4. System.out.println(ex.ch); main方法中ex.ch还是指向堆中的ch数组，而 java 已经修改成了 hava，所以输出hava
     */
    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");//hspand
        System.out.println(ex.ch);//hava
    }
}