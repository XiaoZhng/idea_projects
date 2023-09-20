package com.zledu.homework;

import java.io.*;

/**
 * @author Alonso
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        //使用BufferedReader读取一个文本文件，为每行加上行号，
        //再连同内容一并输出到屏幕上
        String filePath = "e:\\f1.txt";
        String line = "";
        int count = 0;
        //BufferedReader br = new BufferedReader(new FileReader(filePath));
        //中文乱码，在 BufferedReader构造器中指定编码格式
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
        //循环读取
        while ((line = br.readLine()) != null){
            System.out.println((++count) + line);
        }
        br.close();
    }
}
