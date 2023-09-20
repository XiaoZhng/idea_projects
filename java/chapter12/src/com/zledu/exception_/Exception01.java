package com.zledu.exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        //解读
        /**
         * 1.num1 / num2 -> 10 / 0
         * 2.当执行到 num1 / num2 因为 num2 = 0，程序就会出现(抛出)异常 ArithmeticException
         * 3.当抛出异常后，程序就退出，崩溃了，下面代码就不执行
         * 4.大家想想这样的程序好么？ 不好，不应该出现了一个不算致命的问题，就导致整个程序崩溃
         * 5.java 设计者，就提供了一个叫 异常处理机制来解决该问题
         */
        //int res = num1 / num2;
        //如果程序员，认为一段代码可能出现异常/问题，可以使用try-catch异常处理机制来解决
        //从而保证程序的健壮性
        //将该代码块选中，快捷键：ctrl + alt + t -> try-catch
        //5.如果进行异常处理，那么即使出现了异常，程序可以继续执行
        try {
            int res = num1 / num2;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("出现异常的原因："    + e.getMessage());
        }
        System.out.println("程序执行完毕...");

        try {
            //代码可能有异常
        } catch (Exception e) {
            //捕获到异常
            //1.当异常发生时
            //2.系统将异常封装成 Exception 对象e，传递给catch
            //3.得到异常对象后，程序员自己处理
            //4.注意，如果没有发生异常 catch代码块不执行
            e.printStackTrace();
        }finally {
            //1.不管try代码块是否有异常发生，始终要执行finally
            //2.所以，通常将释放资源的代码，放在finally
        }
    }
}
