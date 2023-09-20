package com.mybatis.bean;

/**
 * @author Alonso
 */
public class AA {
}

class Base {
    private String baseName = "base";
    public Base() {
        callName();
    }

    public void callName() {
        System. out. println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";
        public void callName() {
            System. out. println (baseName) ;
        }
    }

    public static void main(String[] args) {
        double d = 0x123;
        try{
            int i = 100 / 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            throw new RuntimeException();
        }finally{
            System.out.print(2);
        }
        System.out.print(3);
    }
}
