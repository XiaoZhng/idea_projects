package com.zledu.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alonso
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 演示使用 FileOutputStream 将数据写到文件中
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile(){

        //创建 FileOutputStream对象
        String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        String str = "hello,write";
        try {
            //得到 fileOutputStream对象
            //1. new FileOutputStream(filePath); 创建方式，当写入内容时，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true); 创建方式，当写入内容时，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            //fileOutputStream.write('A');
            //写入字符串
            //str.getBytes() 可以把 字符串 -> 字节数组
            //fileOutputStream.write(str.getBytes());
            /*
            write(byte[] b, int off, int len) 将len字节从位于偏移量 off的指定字节数组写入此文件输出流
             */
            fileOutputStream.write(str.getBytes(), 0, 3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
