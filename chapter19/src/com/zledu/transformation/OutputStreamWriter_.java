package com.zledu.transformation;

import java.io.*;

/**
 * @author Alonso
 * 演示 OutputStreamWriter 使用
 * 把FileOutputStream 字节流，转换成字符流 OutputStreamWriter
 * 指定处理编码 gbk/utf-8/utf8
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String FilePath = "e:\\b.txt";
        //把 FileOutputStream 传入 OutputStreamWriter，指定编码格式 gbk
        //也可以把编码格式单独写
        String Charset = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FilePath), Charset);
        osw.write("上海，加油!");
        System.out.println("内容写入完毕...");
        //关闭流
        osw.close();
//        PrintStream
//        PrintWriter
    }
}
