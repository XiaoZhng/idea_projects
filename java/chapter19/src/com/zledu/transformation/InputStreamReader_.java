package com.zledu.transformation;

import java.io.*;

/**
 * @author Alonso
 * 演示使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转换成字符流 InputStreamReader，指定编码gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        //读取e:\\a.txt 文件到程序
        String FilePath = "e:\\a.txt";
        //1.把 FileInputStream 转换成 InputStreamReader
        //2.指定编码歌手 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(FilePath), "gbk");
        //3.把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //可以将2，3合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath), "gbk"));

        //4.读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5.关闭流
        br.close();
    }
}
