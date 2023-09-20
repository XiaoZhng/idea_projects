package com.zledu.transformation;

import java.io.*;

/**
 * @author Alonso
 * 先看一个文件乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取e:\\a.txt 文件到程序
        String FilePath = "e:\\a.txt";
        //思路：
        //1.创建字符输入流 BufferedReader [处理流]
        //2.使用 BufferedReader对象读取a.txt
        //3.默认情况下，读取文件是按照 utf-8 编码
        BufferedReader br = new BufferedReader(new FileReader(FilePath));

        String s = br.readLine();
        System.out.println("读取到的内容=" + s);
        br.close();

//        InputStreamReader
//        OutputStreamWriter
    }
}
