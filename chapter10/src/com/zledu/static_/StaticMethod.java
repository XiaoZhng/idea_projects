package com.zledu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu jack = new Stu("jack");
        //jack.payFee(100);
        Stu.payFee(100);

        Stu tom = new Stu("tom");
        //tom.payFee(200);
        Stu.payFee(200);

        //输出总学费
        Stu.showFee();

        /**
         * 如果我们希望不创建实例，也可以调用某个方法(即当做工具来使用)
         * 这时，把方法做成静态方法时非常合适
         */
        System.out.println("9开平方结果:" + Math.sqrt(9));

        System.out.println(myTools.calSum(2,3));
    }
}
//开发自己的工具类时，可以将方法做成静态的，方便调用
class myTools{
    //求两个数的和
    public static double calSum(double num1, double num2){
        return num1 + num2;
    }
    //可以写出很多这种工具方法
}

class Stu{
    private String name;//普通成员变量
    //定义一个静态方法，累积学生的学费
    private static double fee;

    public Stu(String name) {
        this.name = name;
    }

    /**
     * 说明：
     * 1.当方法使用了static修饰后，该方法就是静态方法
     * 2.静态方法可以访问静态属性/变量
     */
    public static void payFee(double fee){
        Stu.fee += fee;//累积学费
    }
    public static void showFee(){
        System.out.println("总学费:" + Stu.fee);
    }
}