package com.zledu.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alonso
 */
public class FileReader_ {
    public static void main(String[] args) {

    }
    /**
     * 单个字符读取文件
     */
    @Test
    public void readerFile01(){
        String filePath = "e:\\story.java";
        FileReader fileReader = null;
        int date = 0;
        try {
            fileReader = new FileReader(filePath);
            //循环读取，使用read，单个字符读取
            while ((date = fileReader.read()) != -1){
                System.out.print((char) date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符数组读取文件
     */
    @Test
    public void readerFile02(){
        String filePath = "e:\\story.java";
        FileReader fileReader = null;
        int len = 0;
        try {
            fileReader = new FileReader(filePath);
            //定义一个字符数组
            char[] chars = new char[1024];
            //循环读取，使用read，返回的是实际读取到的字符数
            while ((len = fileReader.read(chars)) != -1){
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
