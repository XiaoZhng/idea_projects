package com.zledu.object_;

public class Equals01 {
    public static void main(String[] args) {
        // ==是一个比较运算符
        // ==：既可以判断基本类型，也可以判断引用类型
        //如果判断基本类型，判断的是值是否相等  int i = 10; double d = 10.0;
        //如果判断引用类型，判断的是地址是否相等，即判断是不是同一个对象
        A a = new A();
        A b = a;
        A c = b;

        System.out.println(a == b);//true
        System.out.println(b == c);//true

        B b1 = a;
        System.out.println(b1 == c);//true

        //equals 方法，源码查看
        //把光标放在equals方法，直接输入ctrl+b
        //equals 是 Object类中的方法，只能判断引用类型

        /*
        //查看JDK源码 String类的 equals方法
        //把Object的equals方法重写了，变成了比较两个字符串值是否相等
        public boolean equals(Object anObject) {
        if (this == anObject) { //如果传进来的对象就是当前的对象，则返回true
            return true;
         }
            if (anObject instanceof String) { //判断类型是否为String，向下转型
                String anotherString = (String)anObject;
                int n = value.length;
                if (n == anotherString.value.length) { //如果长度相同
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) { //然后一个个的比较字符
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true; //如果两个字符串的所有字符都相等，则返回true
                }
            }
            return false; //如果比较的不是字符串，则返回false
        }
        * */
        "hello".equals("abc");

        //看看Object类的 equals
        /*
        //即Object 的equals 方法默认就是比较对象地址是否相同
        //也就是判断两个对象是不是同一个对象
        public boolean equals(Object obj) {
            return (this == obj);
        }
         */

        /*
        //从源码可以看到 Integer 也重写了Object的equals方法
        //变成了判断两个值是否相等
        public boolean equals(Object obj) {
            if (obj instanceof Integer) {
                return value == ((Integer)obj).intValue();
            }
            return false;
        }
        * */
        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.println(integer1 == integer2);//false
        System.out.println(integer1.equals(integer2));//true

        String str1 = new String("hellp");
        String str2 = new String("hellp");
        System.out.println(str1 == str2);//false
        System.out.println(str1.equals(str2));//true
    }
}

class B{}
class A extends B{}
