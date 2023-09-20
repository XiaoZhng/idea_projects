package com.zledu.exercise_;

public class Exercise03 {
    public static void main(String[] args) {

        //设置命令行的两个参数
        try {
            //先判断args[]数组的长度
            if (!(args.length == 2)){
                throw new ArrayIndexOutOfBoundsException("缺少命令行参数...");
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            //判断除0
            int result = cal(n1, n2);
            System.out.println("计算结果=" + result);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println("数据格式不正确...");
        }catch (ArithmeticException e){
            System.out.println("被除数不能为0...");
        }


    }
    public static int cal(int n1, int n2){
        return n1 / n2;
    }
}




//class Base{
//    private String baseName = "base";
//    public Base(){
//        callName();
//    }
//    public void callName(){
//        System.out.println(baseName);
//    }
//    static class sub extends Base{
//        private String baseName = "sub";
//        public void callName(){
//            System.out.println(baseName);
//        }
//    }
//
//    public static void main(String[] args) {
//        Base sub = new sub();
//    }
//}