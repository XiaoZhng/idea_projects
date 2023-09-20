package com.zledu.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alonso
 */
public class FileCopy {
    public static void main(String[] args) {
        //完成文件拷贝，将 e:\\img1.png 拷贝到 f:\\img1.png
        //思路分析
        //1.创建文件的输入流，将文件读入到程序
        //2.创建文件的输出流，将读取到的文件数据，写入到指定的文件
    }

    @Test
    public void Copy(){
        String filePath = "e:\\img1.png";
        String destPath = "f:\\img1.png";
        FileInputStream fileInputStream = null;//创建文件的输入流
        FileOutputStream fileOutputStream = null;//创建文件的输出流
        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(destPath);

            //定义一个字节数组，提高读取效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1){
                //读取到后，就写入到文件 通过 fileOutputStream
                //即，是一边读一边写
                fileOutputStream.write(buf, 0, readLen);//一定要使用这个方法
            }
            System.out.println("拷贝成功...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流，输出流，释放资源
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void Copys(){
        String srcFile = "e:\\img2.png";//拷贝路径
        String destFile = "f:\\img2.png";//目标路径
        FileInputStream fileInputStream = null;//输入流
        FileOutputStream fileOutputStream = null;//输出流
        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //定义字符数组
            byte[] buf = new byte[1024];
            int readlen = 0;//存储读取的数据
            while ((readlen = fileInputStream.read(buf)) != -1){//等于-1，停止循环
                //边读边写
                fileOutputStream.write(buf, 0, readlen);
            }
            System.out.println("拷贝成功...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流，输出流，释放资源
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
