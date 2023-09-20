package com.zledu.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Alonso
 * 演示 PrintStream(字节打印流/输出流)
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //默认情况下，PrintStream 输出数据的位置是标准输出，即显示器
        /*
            源码
            public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }
         */
        out.print("hello,world");
        //因为print底层使用的是write
        //所以我们可以直接调用write进行打印/输出
        out.write("你好，中国".getBytes());
        out.close();

        //我们可以去修改打印输出的位置/设备
        //1.输出修改成到 "e:\\f1.txt"
        //2."加油，上海..." 就会输出到 "e:\\f1.txt"
        //3.public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out);
        //    }
        System.setOut(new PrintStream("e:\\f1.txt"));
        System.out.println("加油，上海...");
    }
}
