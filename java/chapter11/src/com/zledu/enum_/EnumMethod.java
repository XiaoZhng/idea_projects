package com.zledu.enum_;

//演示Enum类的各种方法的使用

public class EnumMethod {
    public static void main(String[] args) {
        Season2 spring = Season2.SPRING;
        Season2 summer = Season2.SUMMER;
        //name() 输出枚举对象的名字
        System.out.println(spring.name());

        //ordinal() 输出的是该枚举对象的次序/编号，从0开始编号
        //SPRING 枚举类是第一个，因此输出0
        System.out.println(summer.ordinal());
        System.out.println(spring.ordinal());

        //从反编译可以看到values方法，返回Season2[]
        //含有定义的所有枚举对象
        Season2[] values = Season2.values();
        System.out.println("遍历去除枚举对象(增强for)");
        for (Season2 i : values){ //增强for循环
            System.out.println(i);
        }

        //valueOf() 将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报错
        //执行流程：
        //1.根据输入的"SPRING" 到 Season2的枚举对象去查找
        //2.如果找到了，就返回，没找到就报错
        Season2 spring1 = Season2.valueOf("SPRING");
        System.out.println("spring1=" + spring1);

        //compareTo 比较两个枚举常量，比较的就是编号
        //1.就是把 spring 枚举对象的编号 和 Season2.WINTER枚举对象的编号比较
        /**
         * public final int compareTo(E o) {
         *
         *         return self.ordinal - other.ordinal;
         *     }
         *     spring的编号[0] - Season2.WINTER的编号[3]
         */
        System.out.println(spring.compareTo(Season2.WINTER));

        //补充一个增强for循环
//        int[] nums = {1,2,3};
//        System.out.println("普通for---");
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println("i=" + nums[i]);
//        }
//
//        System.out.println("增强for---");
//        for (int i : nums){
//            System.out.println("i=" + i);
//        }
    }
}
