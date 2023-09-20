package com.zledu.printstream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Alonso
 * 演示 PrintWriter
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.println("hello,world");
        printWriter.close();//flush + 关闭流，才会将数据写入到文件..
    }
}
