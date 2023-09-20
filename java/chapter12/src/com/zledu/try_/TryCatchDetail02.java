package com.zledu.try_;

public class TryCatchDetail02 {
    public static void main(String[] args) {
        /**
         * 解读
         * 1.如果try代码块可能有多个异常
         * 2.可以使用多个catch 分别捕获不同的异常，相应处理
         * 3.要求子类异常写在前面，父类异常写在后面
         */
        try {
            Person person = new Person();
            person = null;
            System.out.println("name=" + person.getName());
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;
            System.out.println("res=" + res);
        } catch (NullPointerException e){
            System.out.println("空指针异常=" + e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("算数异常=" + e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person{
    private String name = "jack";

    public String getName() {
        return name;
    }
}