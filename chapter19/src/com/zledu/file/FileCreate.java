package com.zledu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Alonso
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    //方式1 new File(String pathname) //根据路径构建一个File对象
    @Test
    public void create01(){
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        //File file1 = new File("e:\\news1.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent, String child) //根据父目录文件 + 子路径构建
    @Test
    public void create02(){
        File file = new File("e:\\");
        String child = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile 方法，才会真正的，在磁盘创建该文件
        File file1 = new File(file, child);
        try {
            file1.createNewFile();
            System.out.println("创建成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent, String child) //根据父目录 + 子路径构建
    @Test
    public void create03(){
        String parentFile = "e:\\";
//        String parentFile = "e:/";
        String childFile = "news4.txt";
        File file = new File(parentFile, childFile);
        try {
            file.createNewFile();
            System.out.println("创建成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
