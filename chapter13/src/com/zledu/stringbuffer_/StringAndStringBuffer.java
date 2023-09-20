package com.zledu.stringbuffer_;

public class StringAndStringBuffer {
    public static void main(String[] args) {

        //看 String -> StringBuffer
        String str1 = "hello tom";
        //方式一：使用构造器
        //注意：返回的才是stringBuffer对象，对String本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str1);

        //方式二：使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str1);

        //看 StringBuffer -> String
        StringBuffer jack = new StringBuffer("jack");
        //方式一：使用 StringBuffer提供的toString()
        String s = jack.toString();
        //方式二：使用构造器
        String s1 = new String(jack);
    }
}
