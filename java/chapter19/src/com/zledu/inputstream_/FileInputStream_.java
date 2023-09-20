package com.zledu.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Alonso
 * 演示 FileInputStream的使用(字节输入流 文件 -> 程序)
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示读取文件
     * 单个字节的读取，效率比较低
     */
    @Test
    public void readFile01(){
        String filePath = "e:\\hello.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
            //如果返回-1，表示读取完毕
            while ((readDate = fileInputStream.read()) != -1){
                System.out.print((char)readDate);//转成 char 显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void readFile02(){
        String filePath = "e:\\hello.txt";
        int readDate = 0;
        //定义字节数组
        byte[] buf = new byte[8];//一次读取8个字节
        int readlen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组，此方法将阻塞，直到某些输入可用
            //如果返回-1，表示读取完毕
            //如果读取正常，返回实际读取的字节数
            //先读取前8个字节，再把剩下的读取
            while ((readlen = fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf, 0, readlen));//显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
