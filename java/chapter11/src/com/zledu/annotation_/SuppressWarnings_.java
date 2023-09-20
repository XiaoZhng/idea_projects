package com.zledu.annotation_;

public class SuppressWarnings_ {
    public static void main(String[] args) {
        /** @SuppressWarnings
         * 1.当我们不希望看到这些警告的时候，可以使用 @SuppressWarnings 注解来抑制警告信息
         * 2.在{""}中，可以写入你希望抑制(不显示)警告信息
         * 3.可以指定警告的类型
         * 4.关于 @SuppressWarnings 作用范围是和你放置的位置相关
         * 比如 @SuppressWarnings 放置在 main方法，那么抑制警告的范围就是 main
         * 通常我们可以放置具体的语句、方法、类
         */
        //5.看 @SuppressWarnings 源码
        //(1) 放置的位置就是 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
        //(2) 该注解类有数组 String[] value() 设置一个数组比如 {"rawtypes","unchecked","unused"}
        /*
        @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface SuppressWarnings {
                String[] value();
            }
                //@SuppressWarnings({""})
         */
    }
}

